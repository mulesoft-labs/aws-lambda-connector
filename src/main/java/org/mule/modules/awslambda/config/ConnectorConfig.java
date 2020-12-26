package org.mule.modules.awslambda.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.GetAccountSettingsRequest;

import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ConnectionManagement(friendlyName = "Configuration")
public class ConnectorConfig {
    
	private static final Logger logger = LoggerFactory.getLogger(ConnectorConfig.class);

    private String connectionId;
    private static final int AWS_CLIENT_MAX_ERROR_RETRY = 10;
     
    private AWSLambda client;
    
    /**
     * Queue Region
     */
    @Optional
    @Configurable
    @Placement(group = "General")
    @FriendlyName("Region")
    private Regions region;
    
    /**
     * Connect
     * @param accessKey
     *            AWS access key
     * @param secretKey
     *            AWS secret key
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey final String accessKey, @NotNull final String secretKey) throws ConnectionException {
    	if (StringUtils.isBlank(accessKey) || StringUtils.isBlank(secretKey)) {
            throw new ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS, "001", "Access Key or Secret Key is blank");
        }
    	
    	try {
            if (getClient() == null) {
                setClient(createAmazonLambda(accessKey, secretKey));
            }
        } catch (Exception e) {
            throw new ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS, "002", e.getMessage(), e);
        }
    	
    }
    
    @TestConnectivity
    public void testConnect(@ConnectionKey String accessKey, @NotNull String secretKey) throws ConnectionException {

        this.connect(accessKey, secretKey);

        try {
        	GetAccountSettingsRequest request = new GetAccountSettingsRequest();
        	getClient().getAccountSettings(request);
        } catch (Exception e) {
            throw new ConnectionException(ConnectionExceptionCode.UNKNOWN, "003", e.getMessage(), e);
        } finally {
            disconnect();
        }
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
    	if (getClient() != null) {
            setClient(null);
        }
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
    	return getClient() != null;
    }
    
    @ConnectionIdentifier
    public String getConnectionId() {
    	return "amazon_lambda-";
    }
    
    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public AWSLambda getClient(){
    	return client;
    }
    
    public void setClient(AWSLambda client) {
        this.client = client;
    }
    
    private AWSLambda createAmazonLambda(String accessKey, String secretKey){
    	ClientConfiguration clientConfig = new ClientConfiguration();
    	  	
    	AWSLambda amazonLambdaClient = null;
    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
    	amazonLambdaClient = AWSLambdaClientBuilder.standard().withRegion(getRegion()).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    	
    	return amazonLambdaClient;
    }
    
}
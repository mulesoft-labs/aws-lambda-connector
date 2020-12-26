package org.mule.modules.awslambda;

import java.nio.ByteBuffer;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Payload;
import org.mule.modules.awslambda.config.ConnectorConfig;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsRequest;
import com.amazonaws.services.lambda.model.ListFunctionsResult;

@Connector(name="aws-lambda", friendlyName="Amazon Lambda")
public class AWSLambdaConnector {

    @Config
    ConnectorConfig config;
    
    private AWSLambda amazonLambda;

    /**
     * List available Lambda functions processor
     *
     * @return ListFunctionsResult of Lambda functions
     */
    @Processor
    public ListFunctionsResult listFunctions(){
    	
    	ListFunctionsRequest request = new ListFunctionsRequest();
    	ListFunctionsResult response = amazonLambda.listFunctions(request);
    	
    	return response;    	
    }
    /**
     * Call Lambda function processor
     *
     * @param functionName Name of the function to execute in Lambda.
     * @param content Content to pass to lambda function in JSON
     * @return String of JSON response from AWS Lambda
     */
    @Processor
    public String callFunction(String functionName, @Default("#[payload]") Object content) {
    	    	
    	InvokeRequest request = new InvokeRequest();
        request.withFunctionName(functionName).withPayload(content.toString());
        
        InvokeResult invokeResult = null;
        
        try {
            invokeResult = amazonLambda.invoke(request);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        String rawJson = null;
        
        if (invokeResult.getStatusCode() == 200){
        	ByteBuffer byteBuffer = invokeResult.getPayload();
        	             
            try {
                rawJson = new String(byteBuffer.array(), "UTF-8");
            }catch (Exception e) {
     
            }
        } else {
        	rawJson = "{ " + " \"Status\": \"Unable to call Lambda\",\n" + " }";
        }
        
        return rawJson;
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
        this.amazonLambda = config.getClient();
    }

}
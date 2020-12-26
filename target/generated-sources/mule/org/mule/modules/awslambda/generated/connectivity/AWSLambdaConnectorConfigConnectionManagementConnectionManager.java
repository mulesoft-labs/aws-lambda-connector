
package org.mule.modules.awslambda.generated.connectivity;

import com.amazonaws.regions.Regions;
import javax.annotation.Generated;
import org.apache.commons.pool.KeyedObjectPool;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.common.DefaultTestResult;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.config.PoolingProfile;
import org.mule.devkit.api.exception.ConfigurationWarning;
import org.mule.devkit.api.lifecycle.LifeCycleManager;
import org.mule.devkit.api.lifecycle.MuleContextAwareManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorFactory;
import org.mule.devkit.internal.connection.management.ConnectionManagementProcessTemplate;
import org.mule.devkit.internal.connection.management.UnableToAcquireConnectionException;
import org.mule.devkit.internal.connectivity.ConnectivityTestingErrorHandler;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.awslambda.AWSLambdaConnector;
import org.mule.modules.awslambda.config.ConnectorConfig;
import org.mule.modules.awslambda.generated.adapters.AWSLambdaConnectorConnectionManagementAdapter;
import org.mule.modules.awslambda.generated.pooling.DevkitGenericKeyedObjectPool;


/**
 * A {@code AWSLambdaConnectorConfigConnectionManagementConnectionManager} is a wrapper around {@link AWSLambdaConnector } that adds connection management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2018-04-26T02:07:05-05:00", comments = "Build UNNAMED.2810.4347dd1")
public class AWSLambdaConnectorConfigConnectionManagementConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<AWSLambdaConnectorConnectionManagementAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectionManagementConnectionManager<ConnectionManagementConfigAWSLambdaConnectorConnectionKey, AWSLambdaConnectorConnectionManagementAdapter, ConnectorConfig>
{

    /**
     * 
     */
    private String accessKey;
    /**
     * 
     */
    private String secretKey;
    private Regions region;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Connector Pool
     * 
     */
    private KeyedObjectPool connectionPool;
    protected PoolingProfile poolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "Amazon Lambda";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.9.4";
    private final static String DEVKIT_BUILD = "UNNAMED.2810.4347dd1";
    private final static String MIN_MULE_VERSION = "3.5.0";

    /**
     * Sets accessKey
     * 
     * @param value Value to set
     */
    public void setAccessKey(String value) {
        this.accessKey = value;
    }

    /**
     * Retrieves accessKey
     * 
     */
    public String getAccessKey() {
        return this.accessKey;
    }

    /**
     * Sets secretKey
     * 
     * @param value Value to set
     */
    public void setSecretKey(String value) {
        this.secretKey = value;
    }

    /**
     * Retrieves secretKey
     * 
     */
    public String getSecretKey() {
        return this.secretKey;
    }

    /**
     * Sets region
     * 
     * @param value Value to set
     */
    public void setRegion(Regions value) {
        this.region = value;
    }

    /**
     * Retrieves region
     * 
     */
    public Regions getRegion() {
        return this.region;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets poolingProfile
     * 
     * @param value Value to set
     */
    public void setPoolingProfile(PoolingProfile value) {
        this.poolingProfile = value;
    }

    /**
     * Retrieves poolingProfile
     * 
     */
    public PoolingProfile getPoolingProfile() {
        return this.poolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    public void initialise() {
        connectionPool = new DevkitGenericKeyedObjectPool(new ConnectionManagementConnectorFactory(this), poolingProfile);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public AWSLambdaConnectorConnectionManagementAdapter acquireConnection(ConnectionManagementConfigAWSLambdaConnectorConnectionKey key)
        throws Exception
    {
        return ((AWSLambdaConnectorConnectionManagementAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(ConnectionManagementConfigAWSLambdaConnectorConnectionKey key, AWSLambdaConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(ConnectionManagementConfigAWSLambdaConnectorConnectionKey key, AWSLambdaConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

    @Override
    public<P >ProcessTemplate<P, AWSLambdaConnectorConnectionManagementAdapter> getProcessTemplate() {
        return new ConnectionManagementProcessTemplate(this, muleContext);
    }

    @Override
    public ConnectionManagementConfigAWSLambdaConnectorConnectionKey getDefaultConnectionKey() {
        return new ConnectionManagementConfigAWSLambdaConnectorConnectionKey(getAccessKey(), getSecretKey());
    }

    @Override
    public ConnectionManagementConfigAWSLambdaConnectorConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedAccessKey = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("accessKey").getGenericType(), null, getAccessKey()));
            if (_transformedAccessKey == null) {
                throw new UnableToAcquireConnectionException("Parameter accessKey in method connect can't be null because is not @Optional");
            }
            final String _transformedSecretKey = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("secretKey").getGenericType(), null, getSecretKey()));
            if (_transformedSecretKey == null) {
                throw new UnableToAcquireConnectionException("Parameter secretKey in method connect can't be null because is not @Optional");
            }
            return new ConnectionManagementConfigAWSLambdaConnectorConnectionKey(_transformedAccessKey, _transformedSecretKey);
        }
        return getDefaultConnectionKey();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

    @Override
    public ConnectionManagementConfigAWSLambdaConnectorConnectionKey getConnectionKey(MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return getEvaluatedConnectionKey(event);
    }

    @Override
    public ConnectionManagementConnectionAdapter newConnection() {
        ConnectorConfigAWSLambdaConnectorAdapter connection = new ConnectorConfigAWSLambdaConnectorAdapter();
        connection.setRegion(getRegion());
        return connection;
    }

    @Override
    public ConnectionManagementConnectorAdapter newConnector(ConnectionManagementConnectionAdapter<ConnectorConfig, ConnectionManagementConfigAWSLambdaConnectorConnectionKey> connection) {
        AWSLambdaConnectorConnectionManagementAdapter connector = new AWSLambdaConnectorConnectionManagementAdapter();
        connector.setConfig(connection.getStrategy());
        return connector;
    }

    public ConnectionManagementConnectionAdapter getConnectionAdapter(ConnectionManagementConnectorAdapter adapter) {
        AWSLambdaConnectorConnectionManagementAdapter connector = ((AWSLambdaConnectorConnectionManagementAdapter) adapter);
        ConnectionManagementConnectionAdapter strategy = ((ConnectionManagementConnectionAdapter) connector.getConfig());
        return strategy;
    }

    public TestResult test() {
        try {
            ConnectorConfigAWSLambdaConnectorAdapter strategy = ((ConnectorConfigAWSLambdaConnectorAdapter) newConnection());
            MuleContextAwareManager.setMuleContext(strategy, this.muleContext);
            LifeCycleManager.executeInitialiseAndStart(strategy);
            ConnectionManagementConnectorAdapter connectorAdapter = newConnector(strategy);
            MuleContextAwareManager.setMuleContext(connectorAdapter, this.muleContext);
            LifeCycleManager.executeInitialiseAndStart(connectorAdapter);
            strategy.test(getDefaultConnectionKey());
            return new DefaultTestResult(org.mule.common.Result.Status.SUCCESS);
        } catch (ConfigurationWarning warning) {
            return ((DefaultTestResult) ConnectivityTestingErrorHandler.buildWarningTestResult(warning));
        } catch (Exception e) {
            return ((DefaultTestResult) ConnectivityTestingErrorHandler.buildFailureTestResult(e));
        }
    }

}

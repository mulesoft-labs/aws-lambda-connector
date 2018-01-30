
package org.mule.modules.awslambda.generated.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.TestableConnection;
import org.mule.modules.awslambda.config.ConnectorConfig;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-01-30T02:03:43-06:00", comments = "Build UNNAMED.2793.f49b6c7")
public class ConnectorConfigAWSLambdaConnectorAdapter
    extends ConnectorConfig
    implements ConnectionManagementConnectionAdapter<ConnectorConfig, ConnectionManagementConfigAWSLambdaConnectorConnectionKey> , TestableConnection<ConnectionManagementConfigAWSLambdaConnectorConnectionKey>
{


    @Override
    public ConnectorConfig getStrategy() {
        return this;
    }

    @Override
    public void test(ConnectionManagementConfigAWSLambdaConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.testConnect(connectionKey.getAccessKey(), connectionKey.getSecretKey());
    }

    @Override
    public void connect(ConnectionManagementConfigAWSLambdaConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getAccessKey(), connectionKey.getSecretKey());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.getConnectionId();
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

}


package org.mule.modules.awslambda.generated.connectivity;

import javax.annotation.Generated;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionKey;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2018-04-26T02:07:05-05:00", comments = "Build UNNAMED.2810.4347dd1")
public class ConnectionManagementConfigAWSLambdaConnectorConnectionKey implements ConnectionManagementConnectionKey
{

    /**
     * 
     */
    private String accessKey;
    /**
     * 
     */
    private String secretKey;

    public ConnectionManagementConfigAWSLambdaConnectorConnectionKey(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

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

    @Override
    public int hashCode() {
        int result = ((this.accessKey!= null)?this.accessKey.hashCode(): 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectionManagementConfigAWSLambdaConnectorConnectionKey)) {
            return false;
        }
        ConnectionManagementConfigAWSLambdaConnectorConnectionKey that = ((ConnectionManagementConfigAWSLambdaConnectorConnectionKey) o);
        if (((this.accessKey!= null)?(!this.accessKey.equals(that.accessKey)):(that.accessKey!= null))) {
            return false;
        }
        return true;
    }

}

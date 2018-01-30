
package org.mule.modules.awslambda.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.awslambda.AWSLambdaConnector;


/**
 * A <code>AWSLambdaConnectorCapabilitiesAdapter</code> is a wrapper around {@link AWSLambdaConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-01-30T02:03:43-06:00", comments = "Build UNNAMED.2793.f49b6c7")
public class AWSLambdaConnectorCapabilitiesAdapter
    extends AWSLambdaConnector
    implements Capabilities
{


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

}

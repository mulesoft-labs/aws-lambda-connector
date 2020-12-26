
package org.mule.modules.awslambda.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.awslambda.AWSLambdaConnector;


/**
 * A <code>AWSLambdaConnectorMetadataAdapter</code> is a wrapper around {@link AWSLambdaConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2018-04-26T02:07:05-05:00", comments = "Build UNNAMED.2810.4347dd1")
public class AWSLambdaConnectorMetadataAdapter
    extends AWSLambdaConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Amazon Lambda";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.9.4";
    private final static String DEVKIT_BUILD = "UNNAMED.2810.4347dd1";
    private final static String MIN_MULE_VERSION = "3.5.0";

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

}

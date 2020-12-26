
package org.mule.modules.awslambda.generated.devkit;

import javax.annotation.Generated;


/**
 * Marks DevKit {@link org.mule.api.agent.Agent} implementations to take care of logging information at Mule app level mainly for troubleshooting purposes.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2018-04-26T02:07:05-05:00", comments = "Build UNNAMED.2810.4347dd1")
public interface SplashScreenAgent {

      /**
     * Print version information for all the modules used by the application
     */
    void splash();

    /**
     * Retrieve the count of modules used by the application
     *
     * @return
     */
    int getExtensionsCount();
}

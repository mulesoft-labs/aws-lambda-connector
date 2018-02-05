
package org.mule.modules.awslambda.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.awslambda.AWSLambdaConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>AWSLambdaConnectorProcessAdapter</code> is a wrapper around {@link AWSLambdaConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-02-05T09:18:17-08:00", comments = "Build UNNAMED.2793.f49b6c7")
public class AWSLambdaConnectorProcessAdapter
    extends AWSLambdaConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<AWSLambdaConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, AWSLambdaConnectorCapabilitiesAdapter> getProcessTemplate() {
        final AWSLambdaConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,AWSLambdaConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, AWSLambdaConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, AWSLambdaConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}

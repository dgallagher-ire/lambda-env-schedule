package lambda;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;

public class LambdaFunctionHandler implements RequestHandler<SNSEvent, Object> {

    @Override
    public Object handleRequest(SNSEvent input, Context context) {
    	final LambdaLogger logger = context.getLogger();
        final Map<String, String> envVar = System.getenv();
        for(final String key : envVar.keySet()){
        	logger.log(key+":\t"+envVar.get(key));
        }
        return null;
    }

}

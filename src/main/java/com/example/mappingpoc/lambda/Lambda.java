package com.example.mappingpoc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.mappingpoc.LambdaConfiguration;
import com.example.mappingpoc.wsdl.ServiceException;

public class Lambda implements RequestHandler<String, String> {

    private final LambdaConfiguration lambdaConfiguration;

    public Lambda() {
        lambdaConfiguration = new LambdaConfiguration();
    }

    @Override
    public String handleRequest(String s, Context context) {
        context.getLogger().log("Hello from Lambda!\n");
        context.getLogger().log(s + "\n");
        return businessLogic();
    }

    public String businessLogic() {

        try {
            var caseRef = lambdaConfiguration.getSoapClient().createCase();
            System.out.println(caseRef);

            return caseRef;

        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

}

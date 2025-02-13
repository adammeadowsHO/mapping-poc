package com.example.mappingpoc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Lambda implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String s, Context context) {
        context.getLogger().log("Hello from Lambda!\n");
        context.getLogger().log(s + "\n");
        return businessLogic("success");
    }

    public String businessLogic(String s) {
        return s.toUpperCase();
    }

}

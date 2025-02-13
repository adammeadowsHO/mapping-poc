package com.example.mappingpoc.soap;

import com.example.mappingpoc.wsdl.FWTCaseCreate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {


    public String createCase() {
        FWTCaseCreate request = new FWTCaseCreate();


        String response = (String) getWebServiceTemplate()
                .marshalSendAndReceive("todo", request,
                        new SoapActionCallback(
                                "todo"));


        return response;

    }

}

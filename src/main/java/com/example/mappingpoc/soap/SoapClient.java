package com.example.mappingpoc.soap;

import com.example.mappingpoc.wsdl.FWTCaseCreate;
import com.example.mappingpoc.wsdl.FWTException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapClient extends WebServiceGatewaySupport {

    /***
     *
     * @return case reference as string
     */
    public String createCase() {
        FWTCaseCreate request = new FWTCaseCreate();
        String response = (String) getWebServiceTemplate()
                .marshalSendAndReceive(request);

        return response;
    }
}
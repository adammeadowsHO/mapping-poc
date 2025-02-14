package com.example.mappingpoc.soap;

import com.example.mappingpoc.wsdl.FLWebInterface;
import com.example.mappingpoc.wsdl.FWTCaseCreate;
import com.example.mappingpoc.wsdl.ServiceException;

public class SoapClient {

    private final FLWebInterface flWebInterface;

    public SoapClient(FLWebInterface flWebInterface) {
        this.flWebInterface = flWebInterface;
    }

    /***
     *
     * @return case reference as string
     */
    public String createCase() throws ServiceException {

        FWTCaseCreate request = new FWTCaseCreate();
        String aCase = flWebInterface.createCase(request);

        return aCase;
    }
}
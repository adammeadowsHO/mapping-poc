package com.example.mappingpoc.soap;

import com.example.mappingpoc.wsdl.FLWebInterface;
import com.example.mappingpoc.wsdl.FWTCaseCreate;
import com.example.mappingpoc.wsdl.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SoapClient {

    private final FLWebInterface flWebInterface;

    /***
     *
     * @return case reference as string
     */
    public String createCase() throws ServiceException {

        FWTCaseCreate request = new FWTCaseCreate();

        request.setClassificationEventCode(5);
        request.setTitle("Test title");
        request.setDescription("Test description");
        request.setQueue("Test queue");
        /*
         ClassificationEventCode: config.ims.PublicAllegationsEventCode,
    Title: config.ims.title,
    Description: config.ims.description,
    Queue: config.ims.queue
         */

        String aCase = flWebInterface.createCase(request);

        return aCase;
    }
}
package com.example.mappingpoc;

import com.example.mappingpoc.soap.SoapClient;
import com.example.mappingpoc.wsdl.FLWebInterface;
import com.example.mappingpoc.wsdl.FLWebService;

public class ConfigurationFactory {
    public static void main(String[] args) {
        FLWebInterface fl = new FLWebService().getFL();
        SoapClient soapClient = new SoapClient(fl);
    }
}

package com.example.mappingpoc.soap;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import javax.xml.namespace.QName;

import com.example.mappingpoc.config.PropertiesLoader;
import com.example.mappingpoc.wsdl.FLWebInterface;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;

public class CustomWebService extends Service {

    private static final URL FLWEBSERVICE_WSDL_LOCATION;
    private static final WebServiceException FLWEBSERVICE_EXCEPTION;
    private static final QName FLWEBSERVICE_QNAME;
    private static final String namespaceUrl ;

    static {
        String namespaceUrl1 = null;
        URL url = null;
        WebServiceException e = null;
        String namespacePort = null;

        try {
            Properties properties = new PropertiesLoader().loadProperties();
            namespaceUrl1 = properties.getProperty("soap.namespace.url");
            namespacePort = properties.getProperty("soap.namespace.localport");


            url = CustomWebService.class.getClassLoader().getResource("FLService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        namespaceUrl = namespaceUrl1;
        FLWEBSERVICE_WSDL_LOCATION = url;
        FLWEBSERVICE_EXCEPTION = e;
        FLWEBSERVICE_QNAME = new QName(namespaceUrl, namespacePort);
    }

    public CustomWebService() {
        super(__getWsdlLocation(), FLWEBSERVICE_QNAME);
    }

//    public CustomWebService(WebServiceFeature... features) {
//        super(__getWsdlLocation(), FLWEBSERVICE_QNAME, features);
//    }
//
//    public CustomWebService(URL wsdlLocation) {
//        super(wsdlLocation, FLWEBSERVICE_QNAME);
//    }
//
//    public CustomWebService(URL wsdlLocation, WebServiceFeature... features) {
//        super(wsdlLocation, FLWEBSERVICE_QNAME, features);
//    }
//
//    public CustomWebService(URL wsdlLocation, QName serviceName) {
//        super(wsdlLocation, serviceName);
//    }
//
//    public CustomWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     * @return returns FLWebInterface
     */
    @WebEndpoint(name = "FL")
    public FLWebInterface getFL() {
        return super.getPort(new QName(namespaceUrl, "FL"), FLWebInterface.class);
    }

    /**
     * @param features A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns FLWebInterface
     */
    @WebEndpoint(name = "FL")
    public FLWebInterface getFL(WebServiceFeature... features) {
        return super.getPort(new QName(namespaceUrl, "FL"), FLWebInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FLWEBSERVICE_EXCEPTION != null) {
            throw FLWEBSERVICE_EXCEPTION;
        }
        return FLWEBSERVICE_WSDL_LOCATION;
    }

}

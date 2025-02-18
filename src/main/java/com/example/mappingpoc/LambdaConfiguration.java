package com.example.mappingpoc;

import com.example.mappingpoc.config.SecretsManager;
import com.example.mappingpoc.soap.CustomWebService;
import com.example.mappingpoc.soap.SoapClient;
import com.example.mappingpoc.wsdl.FLWebInterface;
import lombok.Value;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

@Value
public class LambdaConfiguration {

    SecretsManager secretsManager;
    SoapClient soapClient;

    public LambdaConfiguration() {
        secretsManager = new SecretsManager();
        authenticateSoap(secretsManager);

        FLWebInterface fl = new CustomWebService().getFL();
        soapClient = new SoapClient(fl);
    }

    private void authenticateSoap(SecretsManager secretsManager) {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(secretsManager.getUsername(), secretsManager.getPassword().toCharArray());
            }
        });
    }
}

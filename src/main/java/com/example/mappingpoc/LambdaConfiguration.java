package com.example.mappingpoc;

import com.example.mappingpoc.config.SecretsManager;
import com.example.mappingpoc.soap.CustomWebService;
import com.example.mappingpoc.soap.SoapClient;
import com.example.mappingpoc.wsdl.FLWebInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

@Value
public class LambdaConfiguration {

    SecretsManager secretsManager;
    SoapClient soapClient;

    public LambdaConfiguration() {
        ObjectMapper objectMapper = getObjectMapper();
        SecretsManagerClient secretsManagerClient = SecretsManagerClient.builder().build();
        secretsManager = new SecretsManager(objectMapper, secretsManagerClient, "/secrets/todo");
        secretsManager.initSecrets();

        FLWebInterface fl = new CustomWebService().getFL();
        soapClient = new SoapClient(fl);
        authenticateSoap(secretsManager);
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
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

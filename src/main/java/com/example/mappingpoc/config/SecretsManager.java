package com.example.mappingpoc.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;

import java.util.LinkedHashMap;

@AllArgsConstructor
@Log
public class SecretsManager {

    private final ObjectMapper objectMapper;
    private final SecretsManagerClient secretsMangerClient;
    private final String secretName;
    private static LinkedHashMap<String, String> secrets;

    public void initSecrets() {
        GetSecretValueRequest request = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();
        try {
            var response = secretsMangerClient.getSecretValue(request).secretString();

            secrets = objectMapper.readValue(response, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSecret(String key) {
        if (secrets == null) {
            throw new IllegalStateException("Secrets not initialized");
        }
        String secret = secrets.get(key);
        if (secret == null) {
            log.warning("Secret not found for key: " + key);
        }
        return secret;
    }

    /*
    Tests only
     */
    protected void setSecrets(LinkedHashMap<String, String> secrets) {
        SecretsManager.secrets = secrets;
    }

    @Deprecated
    public String getUsername() {
        return "username";
    }

    @Deprecated
    public String getPassword() {
        return "password";
    }
}

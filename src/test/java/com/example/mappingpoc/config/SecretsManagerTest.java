package com.example.mappingpoc.config;

import com.example.mappingpoc.LambdaConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SecretsManagerTest extends SampleBaseTestCase {

    private ObjectMapper objectMapper = LambdaConfiguration.getObjectMapper();
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private SecretsManagerClient secretsMangerClient;
    private SecretsManager underTest;

    @BeforeEach
    void setUp() {
        String secretName = "secretName";
        underTest = new SecretsManager(objectMapper, secretsMangerClient, secretName);
        when(secretsMangerClient.getSecretValue((GetSecretValueRequest) any()).secretString()).thenReturn("{\"username\":\"secretUsername\"}");
        underTest.initSecrets();
    }

    @AfterEach
    void tearDown() {
        underTest.setSecrets(null);
    }

    @Test
    void initSecrets() {
        String actual = underTest.getSecret("username");
        assertEquals("secretUsername", actual);
    }

    @Test
    void getSecret_notKnown() {
        String unknown = underTest.getSecret("unknown");
        assertNull(unknown);
    }

    @Test
    void getSecret() {
        String unknown = underTest.getSecret("username");
        assertEquals("secretUsername", unknown);
    }
}
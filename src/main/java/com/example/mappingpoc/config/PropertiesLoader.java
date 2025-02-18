package com.example.mappingpoc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public Properties loadProperties() throws IOException {
        Properties configuration = new Properties();
        try (InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application-prod.properties")) {
            configuration.load(inputStream);
        }
        return configuration;
    }
}

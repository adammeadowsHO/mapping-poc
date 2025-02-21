package com.example.mappingpoc;


import com.example.mappingpoc.wsdl.ServiceException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestConfiguration {
    public static void main(String[] args) {
        var test = new LambdaConfiguration();


        try {
            var lines = Files.readAllLines(Paths.get(TestConfiguration.class.getResource("updated.txt").toURI()));
            System.out.println(lines);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


        try {
            test.getSoapClient().createCase();
        } catch (
                ServiceException e) {
            throw new RuntimeException(e);
        }

    }
}

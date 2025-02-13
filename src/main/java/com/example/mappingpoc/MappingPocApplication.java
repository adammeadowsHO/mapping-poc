package com.example.mappingpoc;

import com.example.mappingpoc.soap.SoapClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingPocApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SoapClient soapClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            var response = soapClient.createCase();
            System.err.println(response);
        };
    }
}

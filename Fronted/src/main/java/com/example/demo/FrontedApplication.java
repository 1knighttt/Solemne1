package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean; // Importación necesaria
import org.springframework.web.client.RestTemplate; // Importación necesaria

@SpringBootApplication
public class FrontedApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontedApplication.class, args);
    }

    // AGREGA ESTO:
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
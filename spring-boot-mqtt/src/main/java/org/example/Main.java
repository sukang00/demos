package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan(basePackages = "org.example")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
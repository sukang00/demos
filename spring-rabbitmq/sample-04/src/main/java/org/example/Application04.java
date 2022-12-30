package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application04 {
    public static void main(String[] args) {
        SpringApplication.run(Application04.class, args).close();
    }
}
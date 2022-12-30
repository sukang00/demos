package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application02 {
    public static void main(String[] args) {
        SpringApplication.run(Application02.class, args).close();
    }
}
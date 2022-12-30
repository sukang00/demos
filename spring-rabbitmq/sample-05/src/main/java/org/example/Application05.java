package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application05 {
    public static void main(String[] args) {
        SpringApplication.run(Application05.class, args).close();
    }
}
package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/4 10:21
 */
@SpringBootApplication
@MapperScan("org.example.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
package org.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication(scanBasePackages = {"org.test"})
@MapperScan(basePackages = "org.test")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

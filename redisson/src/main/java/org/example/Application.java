package org.example;

import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/4 10:21
 */
@SpringBootApplication(scanBasePackages = {"org.example","org.jeecg.boot.starter"})
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
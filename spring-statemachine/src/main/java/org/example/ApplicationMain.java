package org.example;

import org.example.common.Events;
import org.example.common.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 14:36
 */
@SpringBootApplication
public class ApplicationMain implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}

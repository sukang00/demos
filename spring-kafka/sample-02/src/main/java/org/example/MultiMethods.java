package org.example;

import org.example.common.Bar2;
import org.example.common.Foo2;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 14:47
 */
@Component
@KafkaListener(id = "multiGroup", topics = { "foos", "bars" })
public class MultiMethods {

    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    @KafkaHandler
    public void foo(Foo2 foo) {
        System.out.println("Received: " + foo);
        terminateMessage();
    }

    @KafkaHandler
    public void bar(Bar2 bar) {
        System.out.println("Received: " + bar);
        terminateMessage();
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Received unknown: " + object);
        terminateMessage();
    }

    private void terminateMessage() {
        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
    }
}

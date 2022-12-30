package org.example;

import org.example.publisher.Publisher1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 13:07
 */
@SpringBootTest
public class Application04Test {

    @Autowired
    private Publisher1 publisher1;
    @Test
    public void sendMessageATest() throws InterruptedException {
        publisher1.sendMessageA();
    }
    @Test
    public void sendMessageBTest() throws InterruptedException {
        publisher1.sendMessageB();
    }
}

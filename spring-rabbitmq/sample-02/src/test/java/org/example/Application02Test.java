package org.example;

import org.example.publisher.Publisher1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 10:14
 */
@SpringBootTest
public class Application02Test {

    @Autowired
    private Publisher1 publisher1;
    @Test
    public void sendMessageTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            publisher1.sendMessage(i);
        }
    }
}

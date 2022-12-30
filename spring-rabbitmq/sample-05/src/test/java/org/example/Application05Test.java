package org.example;

import org.example.publisher.Publisher1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 13:21
 */
@SpringBootTest
public class Application05Test {

    @Autowired
    private Publisher1 publisher1;


    @Test
    public void sendMessageATest() throws InterruptedException {
        publisher1.sendMessage();
    }
}

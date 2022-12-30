package org.example;

import org.example.publisher.Publisher;
import org.example.utils.ConstantUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 15:35
 */
@SpringBootTest
public class Application07Test {

    @Autowired
    private Publisher publisher;


    @Test
    public void sendMessageATest() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            publisher.sendMessage(ConstantUtils.CONFIRM_EXCHANGE,ConstantUtils.CONFIRM_QUEUE,"hello sending "+ i);
        }

    }
}

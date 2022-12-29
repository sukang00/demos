package org.example;

import org.example.producer.ProducerUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 15:48
 */
@SpringBootTest
public class ApplicationTest {

    @Autowired
    ProducerUser producerUser;


    @Test
    public void testUser() throws InterruptedException {
        // 生产者发送消息
        producerUser.produce();
        Thread.sleep(1000);
    }
    @Test
    public void testEntityUser() throws InterruptedException {
        // 生产者发送消息
        producerUser.produceUser();
        Thread.sleep(1000);
    }
}

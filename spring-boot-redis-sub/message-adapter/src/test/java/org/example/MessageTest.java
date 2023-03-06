package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/3 10:28
 */
@SpringBootTest
public class MessageTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void publish() {
        // 使用convertAndSend方法向频道redisChat发布消息
        redisTemplate.convertAndSend("channel1", "我们");
        redisTemplate.convertAndSend("channel2", "你们");

        redisTemplate.convertAndSend("redis.123", "123");
        redisTemplate.convertAndSend("redis.456", "456");
    }
}

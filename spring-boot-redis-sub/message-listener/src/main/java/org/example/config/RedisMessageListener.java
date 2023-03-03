package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/3 10:24
 */
@Component
@Slf4j
public class RedisMessageListener implements MessageListener {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取消息
        byte[] messageBody = message.getBody();
        // 使用值序列化器转换
        Object msg = redisTemplate.getValueSerializer().deserialize(messageBody);
        // 获取监听的频道
        byte[] channelByte = message.getChannel();
        // 使用字符串序列化器转换
        Object channel = redisTemplate.getStringSerializer().deserialize(channelByte);
        // 渠道名称转换
        String patternStr = new String(pattern);
        log.info(patternStr);
        log.info("通道:"+ channel);
        log.info("内容:" + msg );
    }
}

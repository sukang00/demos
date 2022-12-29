package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 15:45
 */
@Component
@Slf4j
public class ConsumerUser {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("notice_queue"))
    public void process(String message) {
        log.info("收到通知：{}", message);
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("notice_user_queue"))
    public void process(User user) {
        log.info("收到用户信息：{}", user);
    }
}

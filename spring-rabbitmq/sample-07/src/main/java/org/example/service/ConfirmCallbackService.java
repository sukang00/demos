package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 15:24
 */
@Component
@Slf4j
public class ConfirmCallbackService implements RabbitTemplate.ConfirmCallback{


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (!b) {
            log.error("消息发送异常!");
        } else {
            log.info("发送者收到确认，correlationData={} ,b={}, s={}", correlationData.getId(), b, s);
        }
    }
}

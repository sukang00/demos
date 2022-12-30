package org.example.publisher;

import lombok.extern.slf4j.Slf4j;
import org.example.utils.ConstantUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 10:10
 */
@Component
@Slf4j
public class Publisher1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者
     * @param
     */
    public void sendMessage() {
        String message1 = "主题模式-message-routingKey-hello.A.rabbit";
        String message2 = "主题模式-message-routingKey-rabbit.B";

        log.info("发送messageA : " + message1);
        rabbitTemplate.convertAndSend(ConstantUtils.WORK_TOPIC_EXCHANGE,"hello.A.rabbit",message1);

        log.info("发送messageB : " + message2);
        rabbitTemplate.convertAndSend(ConstantUtils.WORK_TOPIC_EXCHANGE,"rabbit.B",message2);
    }

}

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
     * @param i
     */
    public void sendMessage(int i) {
        String message = "工作队列-message-"+i;
        log.info("发送消息 : " + message);
        rabbitTemplate.convertAndSend(ConstantUtils.WORK_QUEUE,message);
    }

}

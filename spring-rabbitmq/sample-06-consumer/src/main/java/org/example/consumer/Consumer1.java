package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 10:12
 */
@Component
@RabbitListener(queues = ConstantUtils.WORK_QUEUE_A)
@Slf4j
public class Consumer1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler(isDefault = true)
    public void process(Message message) {
        log.info("Consumer1消费成功  : " + new String(message.getBody()));
        Message response = MessageBuilder.withBody(("receive msg :" + new String(message.getBody())).getBytes()).build();
        CorrelationData correlationData = new CorrelationData(message.getMessageProperties().getCorrelationId());
        rabbitTemplate.sendAndReceive(ConstantUtils.WORK_RPC_EXCHANGE, ConstantUtils.WORK_QUEUE_B, response, correlationData);

    }

}

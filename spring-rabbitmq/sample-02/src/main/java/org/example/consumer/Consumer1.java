package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.utils.ConstantUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 10:12
 */
@Component
@RabbitListener(queues = ConstantUtils.WORK_QUEUE)
@Slf4j
public class Consumer1 {

    @RabbitHandler
    public void process(String message) {
        log.info("Consumer1消费成功  : " + message);
    }

}

package org.example.config;

import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 10:03
 */

@Configuration
public class RabbitConfig {


    /**
     * 队列A
     * @return
     */
    @Bean
    public Queue workQueueA(){
        return new Queue(ConstantUtils.WORK_QUEUE_A);
    }

    /**
     * 队列B
     * @return
     */
    @Bean
    public Queue workQueueB(){
        return new Queue(ConstantUtils.WORK_QUEUE_B);
    }

    /**
     * 交换机
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(ConstantUtils.WORK_DIRECT_EXCHANGE);
    }


    /**
     * 绑定A
     * @param workQueueA
     * @param directExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue workQueueA, DirectExchange directExchange) {
        return BindingBuilder.bind(workQueueA).to(directExchange).with(ConstantUtils.WORK_QUEUE_ROUTINGKEY_A);
    }

    /**
     * 绑定B
     * @param workQueueB
     * @param directExchange
     * @return
     */
    @Bean
    Binding bindingExchangeB(Queue workQueueB, DirectExchange directExchange) {
        return BindingBuilder.bind(workQueueB).to(directExchange).with(ConstantUtils.WORK_QUEUE_ROUTINGKEY_B);
    }

}

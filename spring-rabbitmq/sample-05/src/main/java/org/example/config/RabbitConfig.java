package org.example.config;

import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    TopicExchange topicExchange(){
        return new TopicExchange(ConstantUtils.WORK_TOPIC_EXCHANGE);
    }



    /**
     * 绑定A
     * @param workQueueA
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue workQueueA, TopicExchange topicExchange) {
        return BindingBuilder.bind(workQueueA).to(topicExchange).with(ConstantUtils.WORK_QUEUE_ROUTINGKEY_A);
    }

    /**
     * 绑定B
     * @param workQueueB
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeB(Queue workQueueB, TopicExchange topicExchange) {
        return BindingBuilder.bind(workQueueB).to(topicExchange).with(ConstantUtils.WORK_QUEUE_ROUTINGKEY_B);
    }

}

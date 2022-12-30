package org.example.config;

import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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
    TopicExchange exchange() {
        return new TopicExchange(ConstantUtils.WORK_RPC_EXCHANGE);
    }



    /**
     * 绑定A
     * @param workQueueA
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue workQueueA, TopicExchange exchange) {
        return BindingBuilder.bind(workQueueA).to(exchange).with(ConstantUtils.WORK_QUEUE_A);
    }

    /**
     * 绑定B
     * @param workQueueB
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeB(Queue workQueueB, TopicExchange exchange) {
        return BindingBuilder.bind(workQueueB).to(exchange).with(ConstantUtils.WORK_QUEUE_B);
    }
    /**
     * 使用 RabbitTemplate发送和接收消息
     * 并设置回调队列地址
     */
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setReplyAddress(ConstantUtils.WORK_QUEUE_B);
        template.setReplyTimeout(6000);
        return template;
    }


    /**
     * 给返回队列设置监听器
     */
    @Bean
    SimpleMessageListenerContainer replyContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(ConstantUtils.WORK_QUEUE_B);
        container.setMessageListener(rabbitTemplate(connectionFactory));
        return container;
    }


}

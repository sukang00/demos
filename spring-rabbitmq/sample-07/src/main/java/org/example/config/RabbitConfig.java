package org.example.config;

import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public Queue confirmQueue() {
        return new Queue(ConstantUtils.CONFIRM_QUEUE, true, false, false);
    }

    @Bean
    public FanoutExchange confirmExchange() {
        return new FanoutExchange(ConstantUtils.CONFIRM_EXCHANGE);
    }

    @Bean
    public Binding confirmTestFanoutExchangeAndQueue(
           FanoutExchange confirmExchange,
           Queue confirmQueue) {
        return BindingBuilder.bind(confirmQueue).to(confirmExchange);
    }


}

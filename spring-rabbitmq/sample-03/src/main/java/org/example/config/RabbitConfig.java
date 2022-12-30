package org.example.config;

import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(ConstantUtils.WORK_FANOUT_EXCHANGE);
    }

    /**
     * 绑定A
     * @param workQueueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue workQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(workQueueA).to(fanoutExchange);
    }

    /**
     * 绑定B
     * @param workQueueB
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeB(Queue workQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(workQueueB).to(fanoutExchange);
    }

}

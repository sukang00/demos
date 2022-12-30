package org.example.config;

import org.example.utils.ConstantUtils;
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
     *
     * @return
     */
    @Bean
    public Queue workQueue(){
        return new Queue(ConstantUtils.WORK_QUEUE);
    }

}

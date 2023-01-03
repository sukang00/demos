package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 13:37
 */
@Component
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return new NewTopic("call_back_topic1", 10, (short) 2);
    }

}

package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 13:39
 */
@Component
@Slf4j
public class Consumer {

    @KafkaListener(id = "callBackTopic1", topics = { "call_back_topic1"})
    public void onMessage1(ConsumerRecord<?, byte[]> record){
        log.info("接受到消费："+record.topic()+"-"+record.partition()+"-"+new String(record.value()));
    }

}

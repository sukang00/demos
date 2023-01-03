package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 13:31
 */
@RestController
@Slf4j
public class SendController {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;
    @GetMapping("/kafka/callbackTwo/{message}")

    public void sendMessage3(@PathVariable("message") String callbackMessage) {
        kafkaTemplate.send("call_back_topic1", callbackMessage).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("发送消息失败：" + ex.getMessage());
            }
            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                log.info("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }
        });
    }

    @GetMapping("/kafka/callbackOne/{message}")
    public void sendMessage2(@PathVariable("message") String callbackMessage) {
        kafkaTemplate.send("call_back_topic1", callbackMessage).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            log.info("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            log.info("发送消息失败:" + failure.getMessage());
        });
    }
}

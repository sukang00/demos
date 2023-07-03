package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

/**
 * @author sukang
 * @version 1.0
 * @description: thingsboard 传来消息处理
 * @date 2023/6/28 15:44
 */
@Service
@Slf4j
public class MqttBroker2Handler implements MessageHandler {

    @ServiceActivator(inputChannel = "mqttInputChannelBroker2")
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC, String.class);
        log.info("topic===" + topic);
        Object payload = message.getPayload();
        log.info("message info:"+payload );
    }
}

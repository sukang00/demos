package org.example.handler;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: thingsboard发送消息
 * @date 2023/6/28 16:57
 */
@Component
@MessagingGateway(defaultRequestChannel = "mqttOutputChannelBroker2")
public interface MqttBroker2Gateway {

    /**
     * 发送信息到MQTT服务器
     *
     * @param topic 主题
     * @param message 消息主体
     */
    @Gateway(replyTimeout = 2, requestTimeout = 200)
    String publishMqttMessageWithTopic(String message, @Header(MqttHeaders.TOPIC) String topic);

    /**
     * 发送信息到MQTT服务器
     *
     * @param topic 主题
     * @param qos 对消息处理的几种机制。<br> 0 表示的是订阅者没收到消息不会再次发送，消息会丢失。<br>
     * 1 表示的是会尝试重试，一直到接收到消息，但这种情况可能导致订阅者收到多次重复消息。<br>
     * 2 多了一次去重的动作，确保订阅者收到的消息有一次。
     * @param message 消息主体
     */
    @Gateway(replyTimeout = 2, requestTimeout = 200)
    String publishMqttMessageWithTopic(String message, @Header(MqttHeaders.TOPIC) String topic,@Header(MqttHeaders.QOS) int qos);
}

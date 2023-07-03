package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.event.MqttConnectionFailedEvent;
import org.springframework.integration.mqtt.event.MqttMessageDeliveredEvent;
import org.springframework.integration.mqtt.event.MqttMessageSentEvent;
import org.springframework.integration.mqtt.event.MqttSubscribedEvent;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;

import java.util.Date;
import java.util.UUID;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/7/3 17:27
 */
@Slf4j
@Configuration
@EnableIntegration
public class MqttConfigurationInbound {

    @Autowired
    private MqttConfigPropBroker1 mqttConfigPropBroker1;

    @Autowired
    private MqttConfigPropBroker2 mqttConfigPropBroker2;


    @Bean
    public MqttConnectOptions mqttConnectOptionsBroker1Inbound() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(mqttConfigPropBroker1.getServerURIs());
        options.setUserName(mqttConfigPropBroker1.getUserName());
        options.setPassword(mqttConfigPropBroker1.getPassword());
        options.setKeepAliveInterval(mqttConfigPropBroker1.getKeepAlive());
        options.setCleanSession(mqttConfigPropBroker1.isCleanSession());
        return options;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactoryBroker1Inbound() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptionsBroker1Inbound());
        return factory;
    }

    @Bean
    public MqttConnectOptions mqttConnectOptionsBroker2Inbound() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(mqttConfigPropBroker2.getServerURIs());
        options.setUserName(mqttConfigPropBroker2.getUserName());
        options.setPassword(mqttConfigPropBroker2.getPassword());
        options.setKeepAliveInterval(mqttConfigPropBroker2.getKeepAlive());
        options.setCleanSession(mqttConfigPropBroker2.isCleanSession());
        return options;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactoryBroker2Inbound() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptionsBroker2Inbound());
        return factory;
    }
    @Bean
    public MessageChannel mqttInputChannelBroker1() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel mqttInputChannelBroker2() {
        return new DirectChannel();
    }
    @Bean
    public MessageProducer brokerDeviceMqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                mqttConfigPropBroker1.getClientId()+ UUID.randomUUID().toString() + "_inbound",
                mqttClientFactoryBroker1Inbound(), mqttConfigPropBroker1.getTopic());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setOutputChannel(mqttInputChannelBroker1());
        adapter.setCompletionTimeout(mqttConfigPropBroker1.getTimeout());
        adapter.setQos(1);
        return adapter;
    }
    @Bean
    public MessageProducer brokerThingsBoardMqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                mqttConfigPropBroker2.getClientId()+ UUID.randomUUID().toString() + "_inbound",
                mqttClientFactoryBroker2Inbound(), mqttConfigPropBroker2.getTopic());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setOutputChannel(mqttInputChannelBroker2());
        adapter.setCompletionTimeout(mqttConfigPropBroker2.getTimeout());
        adapter.setQos(1);
        return adapter;
    }

}

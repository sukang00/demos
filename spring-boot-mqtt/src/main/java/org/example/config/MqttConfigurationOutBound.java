package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

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
public class MqttConfigurationOutBound {

    @Autowired
    private MqttConfigPropBroker1 mqttConfigPropBroker1;

    @Autowired
    private MqttConfigPropBroker2 mqttConfigPropBroker2;


    @Bean
    public MqttConnectOptions mqttConnectOptionsBroker1OutBound() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(mqttConfigPropBroker1.getServerURIs());
        options.setUserName(mqttConfigPropBroker1.getUserName());
        options.setPassword(mqttConfigPropBroker1.getPassword());
        options.setKeepAliveInterval(mqttConfigPropBroker1.getKeepAlive());
        options.setCleanSession(mqttConfigPropBroker1.isCleanSession());
        return options;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactoryBroker1OutBound() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptionsBroker1OutBound());
        return factory;
    }

    @Bean
    public MqttConnectOptions mqttConnectOptionsBroker2OutBound() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(mqttConfigPropBroker2.getServerURIs());
        options.setUserName(mqttConfigPropBroker2.getUserName());
        options.setPassword(mqttConfigPropBroker2.getPassword());
        options.setKeepAliveInterval(mqttConfigPropBroker2.getKeepAlive());
        options.setCleanSession(mqttConfigPropBroker2.isCleanSession());
        return options;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactoryBroker2OutBound() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptionsBroker2OutBound());
        return factory;
    }


    @Bean
    public MessageChannel mqttOutputChannelBroker1() {
        return new DirectChannel();
    }

    @Bean
    public MessageHandler mqttOutboundBroker1() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(
                mqttConfigPropBroker1.getClientId()+ UUID.randomUUID().toString() + "_outbound", mqttClientFactoryBroker1OutBound());
        messageHandler.setAsync(true);
        messageHandler.setCompletionTimeout(mqttConfigPropBroker1.getTimeout());
        return messageHandler;
    }

    @Bean
    public IntegrationFlow mqttOutboundFlowBroker1() {
        return IntegrationFlows.from(mqttOutputChannelBroker1())
                .handle(mqttOutboundBroker1())
                .get();
    }
    @Bean
    public MessageChannel mqttOutputChannelBroker2() {
        return new DirectChannel();
    }

    @Bean
    public MessageHandler mqttOutboundBroker2() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(
                mqttConfigPropBroker2.getClientId()+ UUID.randomUUID().toString() + "_outbound", mqttClientFactoryBroker2OutBound());
        messageHandler.setAsync(true);
        messageHandler.setCompletionTimeout(mqttConfigPropBroker2.getTimeout());
        return messageHandler;
    }

    @Bean
    public IntegrationFlow mqttOutboundFlowThingsBoard() {
        return IntegrationFlows.from(mqttOutputChannelBroker2())
                .handle(mqttOutboundBroker2())
                .get();
    }
}

package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/7/3 17:27
 */
@Component("mqttConfigPropBroker2")
@Data
@ConfigurationProperties(prefix = "mqtt.broker2")
public class MqttConfigPropBroker2 extends MqttConfigPropCommon{

}

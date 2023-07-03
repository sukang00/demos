package org.example.config;

import lombok.Data;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/7/3 17:27
 */
@Data
public class MqttConfigPropCommon {
    private String[] serverURIs;
    private String clientId;
    private String userName;
    private char[] password;
    private String topic;
    private int timeout;
    private int keepAlive;
    private boolean cleanSession;
}

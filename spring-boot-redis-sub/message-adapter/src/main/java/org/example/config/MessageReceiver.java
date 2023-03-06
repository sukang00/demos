package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: 消息接收
 * @date 2023/3/3 10:45
 */
@Component
@Slf4j
public class MessageReceiver {

    /**
     * 接收
     * @param message
     * @param channel
     */
    public void receiveMessage(String message,String channel){
        log.info("通道:"+ channel);
        log.info("内容:" + message );
    }

}

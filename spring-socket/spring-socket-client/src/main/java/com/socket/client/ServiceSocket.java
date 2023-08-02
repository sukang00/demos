package com.socket.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ServiceSocket {

    @Autowired
    private WebSocketClient webSocketClient;

    public void sendMessage(String msg){

    }
}

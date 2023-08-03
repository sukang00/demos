package com.socket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.websocket.*;
import java.io.IOException;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@ClientEndpoint
@Slf4j
public class WebSocketClient {

    @OnOpen
    public void onOpen(Session session) {
        log.info("WebSocket opened: " + session.getId());
        SocketManager.add(ConstantUtil.KEY,session);
        session.getAsyncRemote().sendText("hello, server!");

    }
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("Received message from " + session.getId() + ": " + message);
    }
    @OnClose
    public void onClose(Session session) {
        log.info("WebSocket closed: " + session.getId());
        SocketManager.removeAndClose(ConstantUtil.KEY);
    }
    @OnError
    public void onError(Throwable error) {
        log.error("WebSocket error: " + error.getMessage());
    }


}

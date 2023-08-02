package com.socket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-01
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Component
@ServerEndpoint("/websocket")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        log.info("WebSocket opened: {}",session.getId());
        SocketManager.add(session.getId(),session);
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("Received message from " + session.getId() + ": " + message);
        session.getAsyncRemote().sendText("hello, client!");
    }
    @OnClose
    public void onClose(Session session) {
        log.info("WebSocket closed: " + session.getId());
        SocketManager.removeAndClose(session.getId());
    }
    @OnError
    public void onError(Throwable error) {
        log.info("WebSocket error: " + error.getMessage());
    }
}

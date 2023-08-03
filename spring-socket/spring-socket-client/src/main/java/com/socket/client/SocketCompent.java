package com.socket.client;

import org.springframework.stereotype.Component;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.Objects;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class SocketCompent {


    /**
     * 连接
     */
    public void connect(){
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://127.0.0.1:16908"; // Replace with your WebSocket server URL
            container.connectToServer(WebSocketClient.class, URI.create(uri));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Session
     * @return
     * @throws InterruptedException
     */
    public Session getSession() throws InterruptedException {
        Session session = SocketManager.get(ConstantUtil.KEY);
        if (Objects.isNull(session) || !session.isOpen()){
            connect();
            Thread.sleep(1000);
            session = getSession();
        }
        return session;
    }
}

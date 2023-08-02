package com.socket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Component
public class ApplicationListens implements CommandLineRunner, DisposableBean {

    @Override
    public void destroy() throws Exception {
        SocketManager.closeAll();
    }

    @Override
    public void run(String... args) throws Exception {
        connect();
    }

    /**
     * 连接
     */
    private void connect(){
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://localhost:8088/websocket"; // Replace with your WebSocket server URL
            container.connectToServer(WebSocketClient.class, URI.create(uri));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.socket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SocketCompent socketCompent;
    @Override
    public void destroy() throws Exception {
        SocketManager.closeAll();
    }

    @Override
    public void run(String... args) throws Exception {
        socketCompent.connect();
    }


}

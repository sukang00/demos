package com.socket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-01
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocketTest {
    private static ConcurrentHashMap<String, Session> webSocketSet = new ConcurrentHashMap<>();

    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name){

    }

    @OnClose
    public void OnClose(){
       
    }

    @OnMessage
    public void OnMessage(String message){


    }
}

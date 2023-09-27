package com.socket.server;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.websocket.Session;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
    @Scheduled(cron = "*/5 * * * * ?")
    public void sendHeartBeat() {
        log.info("给客户端发送消息：{}",SocketManager.SESSION_POOL.size());
       if (SocketManager.SESSION_POOL.size()> 0){
           for (Session session : SocketManager.SESSION_POOL.values()) {
               JSONObject jsonObject = new JSONObject();
               jsonObject.put("sessionId",session.getId());
               session.getAsyncRemote().sendText(jsonObject.toJSONString());
           }
       }
    }

}

package com.socket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/wesocket")
@Slf4j
public class WebSocketController {

    @Autowired
    private SocketCompent socketCompent;

    @PostMapping("/send")
    public String sendMessage(String msg) throws Exception {
        socketCompent.getSession().getAsyncRemote().sendText(msg);
        return "发送成功";
    }
}

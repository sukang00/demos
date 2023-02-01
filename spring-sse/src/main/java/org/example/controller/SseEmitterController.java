package org.example.controller;

import org.example.server.SseEmitterServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/2/1 9:58
 */
@RestController
@RequestMapping("/sse")
public class SseEmitterController {
    /**
     * 用于创建连接
     */
    @GetMapping("/connect/{userId}")
    public SseEmitter connect(@PathVariable String userId) {
        return SseEmitterServer.connect(userId);
    }

    /**
     * 推送消息
     * @param message
     * @return
     */
    @GetMapping("/push/{message}")
    public ResponseEntity<String> push(@PathVariable(name = "message") String message) {
        SseEmitterServer.batchSendMessage(message);
        return ResponseEntity.ok("SseEmitter 推送消息给所有人");
    }

    /**
     * 关闭链接
     */
    @GetMapping("/close/{userId}")
    public void close(@PathVariable String userId) {
        SseEmitterServer.removeUser(userId);
    }
}

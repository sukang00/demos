package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.utils.ConstantUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 14:43
 */
@RestController
@Slf4j
public class RpcClientController{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send(String message) {

        // 创建消息对象
        Message newMessage = MessageBuilder.withBody(message.getBytes()).build();

        log.info("client send：{}", newMessage);

        //客户端发送消息
        Message result = rabbitTemplate.sendAndReceive(ConstantUtils.WORK_RPC_EXCHANGE, ConstantUtils.WORK_QUEUE_A, newMessage);

        String response = "";
        if (result != null) {
            // 获取已发送的消息的 correlationId
            String correlationId = newMessage.getMessageProperties().getCorrelationId();
            log.info("correlationId:{}", correlationId);

            // 获取响应头信息
            HashMap<String, Object> headers = (HashMap<String, Object>) result.getMessageProperties().getHeaders();

            // 获取 server 返回的消息 id
            String msgId = (String) headers.get("spring_returned_message_correlation");

            if (msgId.equals(correlationId)) {
                response = new String(result.getBody());
                log.info("client receive：{}", response);
            }
        }
        return response;
    }

}

package org.example.producer;

import com.alibaba.fastjson.JSONObject;
import org.example.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 15:38
 */
@Component
public class ProducerUser {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce() {
        User user = new User();
        user.setUserName("lisi");
        user.setAge("30");
        user.setPhone("15199887766");
        rabbitTemplate.convertAndSend("notice_queue", JSONObject.toJSONString(user));
    }

    public void produceUser(){
        User user = new User();
        user.setUserName("里四五");
        user.setAge("40");
        user.setPhone("15199887766");
        rabbitTemplate.convertAndSend("notice_user_queue",user);
    }
}

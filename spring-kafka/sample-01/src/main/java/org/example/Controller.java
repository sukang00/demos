package org.example;

import org.example.common.Foo1;
import org.example.common.Foo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 13:37
 */
@RestController
public class Controller {
    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("topic1", new Foo1(what));
    }

    @PostMapping(path = "/send/foo2/{what}")
    public void sendFoo2(@PathVariable String what) {
        this.template.send("topic1.DLT", what.getBytes(StandardCharsets.UTF_8));
    }
}

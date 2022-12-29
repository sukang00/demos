package org.example;

import org.example.common.Bar1;
import org.example.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 14:47
 */
@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("foos", new Foo1(what));
    }

    @PostMapping(path = "/send/bar/{what}")
    public void sendBar(@PathVariable String what) {
        this.template.send("bars", new Bar1(what));
    }

    @PostMapping(path = "/send/unknown/{what}")
    public void sendUnknown(@PathVariable String what) {
        this.template.send("bars", what);
    }
}

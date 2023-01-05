package org.example;

import org.example.service.FoobarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/5 11:26
 */
@RestController
public class GrpcController {

    @Autowired
    private FoobarService foobarService;

    @GetMapping("/get/{name}")
    public Object grpc(@PathVariable("name")String name){
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append("abc");
        String names = foobarService.receiveGreeting(stringBuilder.toString());
        System.out.println("response.getMessage() = " + names);
        return names;
    }
}

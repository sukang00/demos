package com.example.forestdemo.controller;

import com.example.forestdemo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 14:12
 */
@RestController
@RequestMapping("/simple")
public class SimpleController {

    @Autowired
    private SimpleService simpleService;
    @GetMapping("/hello")
    public String hello(){
        return simpleService.helloForest();
    }

    @GetMapping("/sendRequest")
    public String sendRequest(String userName){
        return simpleService.sendRequest(userName);
    }
}

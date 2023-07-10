package com.example.forestdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.forestdemo.model.LoginData;
import com.example.forestdemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/27 14:58
 */
@RestController
public class HelloController {

    @Autowired
    private MyService myService;
    @GetMapping("/hello")
    public String hello(@RequestBody LoginData loginData){
        return JSONObject.toJSONString(loginData);
    }

    @GetMapping("/hello/user")
    public String hello(String userName){
        return userName;
    }
    @GetMapping("/forestHello")
    public String forestHello(){
        return myService.testClient();
    }
    @GetMapping("/forestHello/user")
    public String sendRequest(String userName){
        return myService.sendRequest(userName);
    }

    @GetMapping("/forestHelloAddress")
    public String forestHelloAddress(){
        return myService.testHelloForest();
    }

    @GetMapping("/forestGetJson")
    public String forestGetJson(){
        return myService.testForestGetJson();
    }
}

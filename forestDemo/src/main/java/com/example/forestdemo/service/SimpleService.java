package com.example.forestdemo.service;

import com.example.forestdemo.client.SimpleClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 14:10
 */
@Service
@Slf4j
public class SimpleService {

    @Resource
    private SimpleClient simpleClient;

    /**
     *
     * @return
     */
    public String helloForest(){
        return simpleClient.helloForest();
    }

    /**
     *
     * @param userName
     * @return
     */
    public String sendRequest(String userName){
        return simpleClient.sendRequest(userName);
    }
}

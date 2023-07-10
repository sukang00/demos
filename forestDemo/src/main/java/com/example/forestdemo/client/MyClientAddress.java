package com.example.forestdemo.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.http.ForestRequest;
import com.example.forestdemo.model.LoginData;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 8:43
 */
@Address(host = "127.0.0.1",port = "8080")
public interface MyClientAddress {

    @Get("/hello")
    String helloForest();

    @Get("/hello/user")
    String sendRequest(@Query("userName") String userName);
    @Get("/hello")
    String getJSONBodyTest(@JSONBody LoginData loginData);
}

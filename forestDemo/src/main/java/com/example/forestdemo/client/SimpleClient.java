package com.example.forestdemo.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.example.forestdemo.interceptors.SimpleInterceptor;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 14:08
 */
@BaseRequest(baseURL = "http://localhost:8080", interceptor = SimpleInterceptor.class)
public interface SimpleClient {

    @Get("/hello")
    String helloForest();

    @Get("/hello/user")
    String sendRequest(@Query("userName") String userName);
}

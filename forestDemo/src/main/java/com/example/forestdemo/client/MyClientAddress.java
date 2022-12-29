package com.example.forestdemo.client;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.http.ForestRequest;

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
}

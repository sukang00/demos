package com.example.forestdemo.client;

import com.dtflys.forest.annotation.Get;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/27 15:23
 */
public interface MyClient {

    @Get("http://localhost:8080/hello")
    String helloForest();
}

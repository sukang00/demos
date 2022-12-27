package com.example.forestdemo.service;

import com.example.forestdemo.client.MyClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/27 15:25
 */
@Slf4j
@Service
public class MyService {

    // 注入自定义的 Forest 接口实例
    @Resource
    private MyClient myClient;

    public String testClient() {
        // 调用自定义的 Forest 接口方法
        // 等价于发送 HTTP 请求，请求地址和参数即为 helloForest 方法上注解所标识的内容
        String result = myClient.helloForest();
        // result 即为 HTTP 请求响应后返回的字符串类型数据
        log.info(result);
        return result;
    }
}

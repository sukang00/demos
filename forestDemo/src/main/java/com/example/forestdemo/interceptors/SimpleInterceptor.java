package com.example.forestdemo.interceptors;

import com.dtflys.forest.converter.ForestEncoder;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 14:03
 */
@Component
@Slf4j
public class SimpleInterceptor implements Interceptor<String> {

    /**
     * 该方法在被调用时，并在beforeExecute前被调用
     * @Param request Forest请求对象
     * @Param args 方法被调用时传入的参数数组
     */
    @Override
    public void onInvokeMethod(ForestRequest req, ForestMethod method, Object[] args) {
        log.info("on invoke method");
        // req 为Forest请求对象，即 ForestRequest 类实例
        // method 为Forest方法对象，即 ForestMethod 类实例
        // addAttribute作用是添加和Forest请求对象以及该拦截器绑定的属性
        addAttribute(req, "A", "value1");
        addAttribute(req, "B", "value2");
    }

    /**
     * 在请求体数据序列化后，发送请求数据前调用该方法
     * 默认为什么都不做
     * 注: multlipart/data类型的文件上传格式的 Body 数据不会调用该回调函数
     *
     * @param request Forest请求对象
     * @param encoder Forest转换器
     * @param encodedData 序列化后的请求体数据
     */
    @Override
    public byte[] onBodyEncode(ForestRequest request, ForestEncoder encoder, byte[] encodedData) {
        // request: Forest请求对象
        // encoder: 此次转换请求数据的序列化器
        // encodedData: 序列化后的请求体字节数组
        // 返回的字节数组将替换原有的序列化结果
        // 默认不做任何处理，直接返回参数 encodedData
        return encodedData;
    }


    /**
     * 该方法在请求发送之前被调用, 若返回false则不会继续发送请求
     * @Param request Forest请求对象
     */
    @Override
    public boolean beforeExecute(ForestRequest req) {
        log.info("invoke Simple beforeExecute");
        // 执行在发送请求之前处理的代码
        req.addHeader("accessToken", "11111111");  // 添加Header
        req.addQuery("username", "foo");  // 添加URL的Query参数
        return true;  // 继续执行请求返回true
    }

    /**
     * 该方法在请求成功响应时被调用
     */
    @Override
    public void onSuccess(String data, ForestRequest req, ForestResponse res) {
        log.info("invoke Simple onSuccess");
        // 执行成功接收响应后处理的代码
        int status = res.getStatusCode(); // 获取请求响应状态码
        String content = res.getContent(); // 获取请求的响应内容
        String result = (String)data;  // data参数是方法返回类型对应的返回数据结果,注意需要视情况修改对应的类型否则有可能出现类转型异常
        result = (String) res.getResult(); // getResult()也可以获取返回的数据结果
        res.setResult("修改后的结果: " + result);  // 可以修改请求响应的返回数据结果

        // 使用getAttributeAsString取出属性，这里只能取到与该Forest请求对象，以及该拦截器绑定的属性
        String attrValue1 = getAttributeAsString(req, "A1");

    }

    /**
     * 该方法在请求发送失败时被调用
     */
    @Override
    public void onError(ForestRuntimeException ex, ForestRequest req, ForestResponse res) {
        log.info("invoke Simple onError");
        // 执行发送请求失败后处理的代码
        int status = res.getStatusCode(); // 获取请求响应状态码
        String content = res.getContent(); // 获取请求的响应内容
        String result = (String) res.getResult(); // 获取方法返回类型对应的返回数据结果
    }

    /**
     * 该方法在请求发送之后被调用
     */
    @Override
    public void afterExecute(ForestRequest req, ForestResponse res) {
        log.info("invoke Simple afterExecute");
        // 执行在发送请求之后处理的代码
        int status = res.getStatusCode(); // 获取请求响应状态码
        String content = res.getContent(); // 获取请求的响应内容
        String result = (String) res.getResult(); // 获取方法返回类型对应的最终数据结果
    }
}

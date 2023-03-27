package org.example.controller;

import org.example.utils.EwsMailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/27 11:26
 */
@RestController
public class EwsController {
    @Autowired
    private EwsMailComponent emsMailComponent;
    @GetMapping("/sendMail")
    public void sendMail(){
        try {
            emsMailComponent.send("测试", Arrays.asList("v-sukang@sinooceangroup.com"),"测试内容",1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

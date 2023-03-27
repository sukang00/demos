package org.example;

import org.example.utils.EwsMailComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/27 11:03
 */
@SpringBootTest
public class DoMainTest {

    @Autowired
    private EwsMailComponent emsMailComponent;

    @Test
    public void send() throws Exception {
        emsMailComponent.send("测试", Arrays.asList("v-sukang@sinooceangroup.com"),"测试内容",1);
    }
}

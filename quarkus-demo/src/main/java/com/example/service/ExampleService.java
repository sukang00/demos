package com.example.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/10/26 14:50
 */
@ApplicationScoped
public class ExampleService {



    /**
     *
     * @param name
     * @return
     */
    public String searchName(String name) {
        return "hello is " + name;
    }
}

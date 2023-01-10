package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.service.IUserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/10 10:34
 */
@Service
@CacheConfig(cacheNames = "user")
@Slf4j
public class UserService implements IUserService {


    /**
     * 使用@CachePut注解的方法，一定要有返回值，该注解声明的方法缓存的是方法的返回结果。
     * @return
     */
    @Override
    @CachePut(key = "#user.getId()", value = "UserService")
    public User InsertUser(User user) {
        log.info("添加");
        return user;
    }

    @Override
    @Cacheable(key = "#id", value = "UserService")
    public User findUser(Long id) {
        log.info("查找用户");
        return new User();
    }

    @Override
    @CachePut(key = "#user.getId()", value = "UserService")
    public User updateUser(User user) {
        log.info("更新用户");
        return user;
    }

    @Override
    @CacheEvict(key = "#id" ,value = "UserService")
    public void clearUser(Long id) {
        log.info("删除用户");
    }
}

package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.annotation.CaffeineRedisCache;
import org.example.entity.User;
import org.example.enums.CacheTypeEnum;
import org.example.service.IUserService;
import org.example.utils.ContanstUtil;
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
    @CaffeineRedisCache(key = "#user.getId()", cacheName = ContanstUtil.SECOND_CACHE,type = CacheTypeEnum.PUT)
    public User InsertUser(User user) {
        log.info("添加");
        user.setRemark("修改");
        return user;
    }

    @Override
    @CaffeineRedisCache(key = "#id", cacheName = ContanstUtil.SECOND_CACHE,type = CacheTypeEnum.FULL,className = User.class)
    public User findUser(Long id) {
        log.info("查找用户");
        User user = new User();
        user.setId(id);
        user.setName("test");
        user.setEmail("test@126.com");
        return user;
    }

    @Override
    @CaffeineRedisCache(key = "#user.getId()", cacheName = ContanstUtil.SECOND_CACHE,type = CacheTypeEnum.PUT)
    public User updateUser(User user) {
        log.info("更新用户");
        return user;
    }

    @Override
    @CaffeineRedisCache(key = "#id" ,cacheName = ContanstUtil.SECOND_CACHE,type = CacheTypeEnum.DELETE)
    public void clearUser(Long id) {
        log.info("删除用户");
    }
}

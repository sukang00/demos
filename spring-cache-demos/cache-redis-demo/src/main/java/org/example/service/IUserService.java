package org.example.service;

import org.example.entity.User;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/10 10:33
 */
public interface IUserService {

    /**
     * 更新用户信息
     */
    User InsertUser(User user);
    /**
     * 获取用户
     */
    User findUser(Long id);

    /**
     * 更新用户信息
     */
    User updateUser(User user);

    /**
     * 清除缓存的用户信息
     */
    void clearUser(Long id);

}

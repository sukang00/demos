package org.example.controller;

import org.example.entity.User;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/10 11:05
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;


    @PostMapping("/insert")
    public User InsertUser(@RequestBody User user){
        return userService.InsertUser(user);
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Long id){
        return userService.findUser(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void clearUser(@PathVariable("id") Long id){
        userService.clearUser(id);
    }


}

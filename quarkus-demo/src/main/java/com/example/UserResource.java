package com.example;

import com.alibaba.fastjson.JSON;
import com.example.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:55
 */
@Path("/user")
public class UserResource {

    @Inject
    UserService userService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public String getList() {
        return JSON.toJSONString(userService.get());
    }
}

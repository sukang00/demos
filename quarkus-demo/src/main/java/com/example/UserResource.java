package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.Result;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

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
    @Inject
    Validator validator;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<User> getList() {
        return userService.get();
    }

    @Path("/add")
    @POST
    public Result tryMeManualValidation(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (violations.isEmpty()) {
            userService.create(user);
            return new Result("添加成功");
        } else {
            return new Result(violations);
        }
    }
    @Path("/add2")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeEndPointMethodValidation(User user) {
        try {
            userService.create2(user);
            return new Result("添加成功");
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }
}

package com.example;

import com.example.entity.pojo.Increment;
import com.example.service.RedisClientService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/11/4 16:39
 */
@Path("/increments")
public class IncrementResource {
    @Inject
    RedisClientService redisClientService;

    @GET
    public Uni<List<String>> keys() {
        return redisClientService.keys();
    }

    @POST
    public Increment create(Increment increment) {
        redisClientService.set(increment.key, increment.value);
        return increment;
    }

    @GET
    @Path("/{key}")
    public Increment get(String key) {
        return new Increment(key, redisClientService.get(key));
    }

    @PUT
    @Path("/{key}")
    public void increment(String key, long value) {
        redisClientService.increment(key, value);
    }

    @DELETE
    @Path("/{key}")
    public Uni<Void> delete(String key) {
        return redisClientService.del(key);
    }
}

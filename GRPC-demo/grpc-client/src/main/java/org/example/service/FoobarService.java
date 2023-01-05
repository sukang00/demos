package org.example.service;


import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.HelloRequest;
import org.example.MyServiceGrpc;
import org.springframework.stereotype.Service;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/5 8:52
 */
@Service
public class FoobarService {

    @GrpcClient("grpc-server")
    private MyServiceGrpc.MyServiceBlockingStub myServiceStub;


    public String receiveGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return myServiceStub.sayHello(request).getMessage();
    }
}

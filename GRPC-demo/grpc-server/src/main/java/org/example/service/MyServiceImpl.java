package org.example.service;

import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;
import org.example.HelloReply;
import org.example.HelloRequest;
import org.example.MyServiceGrpc;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/5 8:59
 */
@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase{

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

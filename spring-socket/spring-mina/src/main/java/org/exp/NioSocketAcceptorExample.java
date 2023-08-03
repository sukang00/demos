package org.exp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
/**
 * @Author: sukang
 * @CreateTime: 2023-08-03
 * @Description: TODO
 * @Version: 1.0
 */
public class NioSocketAcceptorExample {

    public static void main(String[] args) {
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(StandardCharsets.UTF_8)));
        acceptor.setHandler(new MyIoHandler());
        try {
            acceptor.bind(new InetSocketAddress(8082));
            System.out.println("Server started on port 8082.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class MyIoHandler extends IoHandlerAdapter {
        @Override
        public void sessionOpened(IoSession session) throws Exception {
            System.out.println("New client connected: " + session.getRemoteAddress());
        }

        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {
            String receivedMessage = (String) message;
            System.out.println("Received message from client: " + receivedMessage);
            // Process the received message or send a response back to the client
            // ...
        }

        @Override
        public void sessionClosed(IoSession session) throws Exception {
            System.out.println("Client disconnected: " + session.getRemoteAddress());
        }
    }
}

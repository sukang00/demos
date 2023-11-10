package org.exp;

import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-03
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class MinaClient {

    private static String HOST = "127.0.0.1";

    private static int PORT = 16908;

    public static void main(String[] args) {
        //创建一个非阻塞的客户端
        IoConnector connector = new NioSocketConnector();
        //设置链接超时时间
        connector.setConnectTimeoutMillis(30000);
        //添加过滤器
        connector.getFilterChain().addLast(   //添加消息过滤器
                "codec",
                //Mina自带的根据文本换行符编解码的TextLineCodec过滤器 看到\r\n就认为一个完整的消息结束了
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("GBK"),
                        LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue()
                )));
        //添加业务逻辑处理器类
        connector.setHandler(new IoHandlerAdapter(){
            @Override
            public void sessionCreated(IoSession session) throws Exception {
                super.sessionCreated(session);
                log.info("sessionCreated");
            }

            @Override
            public void sessionOpened(IoSession session) throws Exception {
                super.sessionOpened(session);
                log.info("sessionOpened");
            }

            @Override
            public void sessionClosed(IoSession session) throws Exception {
                super.sessionClosed(session);
                log.info("sessionClosed");
            }

            @Override
            public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
                super.sessionIdle(session, status);
                log.info("sessionIdle");
            }

            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                log.info("exceptionCaught");
            }

            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                super.messageReceived(session, message);
                log.info("messageReceived:{}",message);
            }

            @Override
            public void messageSent(IoSession session, Object message) throws Exception {
                super.messageSent(session, message);
                log.info("messageSent");
            }

            @Override
            public void inputClosed(IoSession session) throws Exception {
                super.inputClosed(session);
                log.info("inputClosed");
            }
        });
        IoSession session = null;
        try {
            ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));
            future.awaitUninterruptibly(); //等待连接创建完成
            session = future.getSession();
            log.info("连接完成");
            //发送信息
            while(true){
                log.info("请输入：");
                BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
                session.write(in.readLine());
            }

            //session.write("我爱你mina");
        } catch (Exception e) {
            log.error("客户端链接异常...", e);
        }

        session.getCloseFuture().awaitUninterruptibly();
        log.info("我们要关闭了");
        connector.dispose();
    }
}

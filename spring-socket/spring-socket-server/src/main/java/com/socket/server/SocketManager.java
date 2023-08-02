package com.socket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-02
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class SocketManager {

    /**
     * 保存连接 session 的地方
     */
    public  static ConcurrentHashMap<String, Session> SESSION_POOL = new ConcurrentHashMap<>();

    /**
     * 添加 session
     *
     * @param key
     */
    public static void add(String key, Session session) {
        // 添加 session
        SESSION_POOL.put(key, session);
    }

    /**
     * 删除 session,会返回删除的 session
     *
     * @param key
     * @return
     */
    public static Session remove(String key) {
        // 删除 session
        return SESSION_POOL.remove(key);
    }

    /**
     * 删除并同步关闭连接
     *
     * @param key
     */
    public static void removeAndClose(String key) {
        Session session = remove(key);
        if (session != null) {
            try {
                // 关闭连接
                session.close();
            } catch (IOException e) {
                log.error("socket关闭异常",e);
            }
        }
    }

    /**
     * 获得 session
     *
     * @param key
     * @return
     */
    public static Session get(String key) {
        // 获得 session
        return SESSION_POOL.get(key);
    }

    /**
     * 关闭所有socket
     */
    public static void closeAll(){
        if (SESSION_POOL.size() > 0){
            for (Session session : SESSION_POOL.values()) {
                try {
                    // 关闭连接
                    session.close();
                } catch (IOException e) {
                    log.error("socket关闭异常",e);
                }
            }
            SESSION_POOL.clear();
        }
    }
}

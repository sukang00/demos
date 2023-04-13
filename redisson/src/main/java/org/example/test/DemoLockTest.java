package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.lock.annotation.JLock;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/4/13 10:31
 */
@Slf4j
@Component
public class DemoLockTest {

    @Autowired
    RedissonLockClient redissonLock;

    /**
     *注解方式测试分布式锁
     */
    @Scheduled(cron = "0/5 * * * * ?")
    @JLock(lockKey= "redis-lock")
    public void execute() throws InterruptedException {
        log.info("执行execute任务开始，休眠三秒");
        Thread.sleep(3000);
        System.out.println("=======================业务逻辑1=============================");
        log.info("execute任务结束，休眠三秒");
    }

    /**
     * 编码方式测试分布式锁
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void execute2() throws InterruptedException {
        if (redissonLock.tryLock("redisson", -1, 10000)) {
            log.info("执行任务execute2开始，休眠三秒");
            Thread.sleep(3000);
            System.out.println("=======================业务逻辑2=============================");
            log.info("定时execute2结束，休眠三秒");
            redissonLock.unlock("redisson");
        } else {
            log.info("execute2获取锁失败");
        }
    }

}

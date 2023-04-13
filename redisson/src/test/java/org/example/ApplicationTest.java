package org.example;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.lock.annotation.JLock;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/4/13 10:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ApplicationTest {

    @Resource
    RedissonLockClient redissonLock;

    /**
     *注解方式测试分布式锁
     */
    @JLock(lockKey= "redis-lock1")
    @Test
    public void execute() throws InterruptedException {
        log.info("执行execute任务开始，休眠三秒");
        Thread.sleep(3000);
        System.out.println("=======================业务逻辑1=============================");
        log.info("execute任务结束，休眠三秒");
    }

    /**
     * 编码方式测试分布式锁
     */
    @Test
    public void execute2() throws InterruptedException {
        if (redissonLock.tryLock("redisson1", 10, 10000)) {
            log.info("执行任务execute2开始，休眠三秒");
            Thread.sleep(3000);
            System.out.println("=======================业务逻辑2=============================");
            log.info("定时execute2结束，休眠三秒");
            redissonLock.unlock("redisson1");
        } else {
            log.info("execute2获取锁失败");
        }
    }


}

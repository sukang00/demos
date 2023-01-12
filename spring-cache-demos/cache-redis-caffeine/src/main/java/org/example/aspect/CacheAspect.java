package org.example.aspect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.annotation.CaffeineRedisCache;
import org.example.enums.CacheTypeEnum;
import org.example.utils.ContanstUtil;
import org.example.utils.ElParserUtil;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/11 9:57
 */
@Slf4j
@Component
@Aspect
@AllArgsConstructor
public class CacheAspect {

    private final CacheManager cacheManager;
    private final RedisTemplate redisTemplate;

    @Pointcut("@annotation(org.example.annotation.CaffeineRedisCache)")
    public void cacheAspect() {
    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        //拼接解析springEl表达式的map
        String[] paramNames = signature.getParameterNames();
        Object[] args = point.getArgs();
        TreeMap<String, Object> treeMap = new TreeMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            treeMap.put(paramNames[i],args[i]);
        }

        CaffeineRedisCache annotation = method.getAnnotation(CaffeineRedisCache.class);
        String elResult = ElParserUtil.parse(annotation.key(), treeMap);
        String realKey = annotation.cacheName() + ContanstUtil.REDIS_CONCAT + elResult;

        Cache cache = cacheManager.getCache(annotation.cacheName());
        if (Objects.isNull(cache)){
            log.error("{} cache not found", cache);
            return null;
        }
        // 更新
        if (annotation.type()== CacheTypeEnum.PUT){
            log.info("更新");
            Object object = point.proceed();
            redisTemplate.opsForValue().set(realKey, object,annotation.ltimeOut(), TimeUnit.SECONDS);
            cache.put(realKey, object);
            return object;
        }
        // 删除
        else if (annotation.type()== CacheTypeEnum.DELETE){
            log.info("删除");
            redisTemplate.delete(realKey);
            cache.evict(realKey);
            return point.proceed();
        }

        // 查询Caffeine
        Object caffeineCache = cache.get(realKey,annotation.className());
        if (Objects.nonNull(caffeineCache)) {
            log.info("from caffeine");
            return caffeineCache;
        }

        // 查询Redis
        Object redisCache = redisTemplate.opsForValue().get(realKey);
        if (Objects.nonNull(redisCache)) {
            log.info("from redis");
            cache.put(realKey, redisCache);
            return redisCache;
        }

        log.info("from DB");
        Object object = point.proceed();
        if (Objects.nonNull(object)){
            //写入Redis
            redisTemplate.opsForValue().set(realKey, object,annotation.ltimeOut(), TimeUnit.SECONDS);
            //写入Caffeine
            cache.put(realKey, object);
        }
        return object;
    }
}

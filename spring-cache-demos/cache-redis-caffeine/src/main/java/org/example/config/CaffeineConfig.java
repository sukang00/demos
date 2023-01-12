package org.example.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.example.enums.CacheEnum;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.ArrayList;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/10 13:21
 */
@Configuration
public class CaffeineConfig {

    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caffeineCaches = new ArrayList<>();
        for (CacheEnum cacheEnum : CacheEnum.values()) {
            caffeineCaches.add(new CaffeineCache(cacheEnum.getName(),
                    Caffeine.newBuilder().expireAfterWrite(Duration.ofSeconds(cacheEnum.getSecond()))
                            .initialCapacity(cacheEnum.getInitSize())
                            .maximumSize(cacheEnum.getMaxSize()).build()));
        }
        cacheManager.setCaches(caffeineCaches);
        return cacheManager;
    }


}

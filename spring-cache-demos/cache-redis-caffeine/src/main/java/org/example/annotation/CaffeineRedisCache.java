package org.example.annotation;

import org.example.enums.CacheTypeEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CaffeineRedisCache {

    /**
     * 缓存名称
     * @return
     */
    String cacheName();

    /**
     * 支持springEl表达式
     * @return
     */
    String key();


    long ltimeOut() default 120;

    Class<?> className() default Object.class;

    CacheTypeEnum type() default CacheTypeEnum.FULL;
}

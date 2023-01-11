package org.example.enums;

import org.example.utils.ContanstUtil;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/10 13:28
 */
public enum CacheEnum {


    FIRST_CACHE(ContanstUtil.FIRST_CACHE,30, 200, 100),

    SECOND_CACHE(ContanstUtil.SECOND_CACHE,60, 300, 100);

    private String name;
    private int second;
    private long maxSize;
    private int initSize;

    CacheEnum(String name,int second, long maxSize, int initSize) {
        this.name = name;
        this.second = second;
        this.maxSize = maxSize;
        this.initSize = initSize;
    }

    public String getName() {
        return name;
    }

    public int getSecond() {
        return second;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public int getInitSize() {
        return initSize;
    }
}

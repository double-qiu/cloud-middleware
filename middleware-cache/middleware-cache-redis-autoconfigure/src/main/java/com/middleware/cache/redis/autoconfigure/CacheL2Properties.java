package com.middleware.cache.redis.autoconfigure;

/**
 * cache l2 config
 */
public class CacheL2Properties {
    private Integer maxCacheCount;
    private Integer maxCacheMemory;

    public Integer getMaxCacheCount() {
        return maxCacheCount;
    }

    public void setMaxCacheCount(Integer maxCacheCount) {
        this.maxCacheCount = maxCacheCount;
    }

    public Integer getMaxCacheMemory() {
        return maxCacheMemory;
    }

    public void setMaxCacheMemory(Integer maxCacheMemory) {
        this.maxCacheMemory = maxCacheMemory;
    }
}

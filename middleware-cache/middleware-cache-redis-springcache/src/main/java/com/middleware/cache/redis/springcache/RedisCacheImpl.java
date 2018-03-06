package com.middleware.cache.redis.springcache;


import java.util.Set;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.middleware.cache.core.CacheException;
import com.middleware.cache.core.CacheHandler;

/**
 * @author DOUBLE 2017-08-10
 */
public class RedisCacheImpl extends AbstractValueAdaptingCache {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Object lock = new Object();
    private final CacheHandler cacheHandler;
    private final String name;
    private final int cacheTime;
    
    public static final String CACHE_KEY = "SPRING_";
    public static final String CACHE_KEYS = CACHE_KEY + "KEYS_";

    RedisCacheImpl(CacheHandler cacheHandler, String name, int cacheTime) {
        super(false);
        this.cacheHandler = cacheHandler;
        this.name = name;
        this.cacheTime = cacheTime;
    }

    @Override
    protected Object lookup(Object key) {
        return cacheHandler.getObject(toKey(key));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return cacheHandler;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        String sKey = toKey(key);
        T value = cacheHandler.getObject(sKey);
        if (value == null) {
            synchronized (lock) {
                value = cacheHandler.getObject(sKey);
                if (value == null) {
                    try {
                        value = valueLoader.call();
                    } catch (Exception e) {
                        throw new CacheException("获取数据异常", e);
                    }
                    if (value == null) {
                        return null;
                    }
                    this.setValue(sKey, value);
                }
            }
        }
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        this.setValue(toKey(key), value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        String sKey = toKey(key);
        Object oldValue = cacheHandler.getObject(sKey);
        if (oldValue == null) {
            this.setValue(sKey, value);
            return null;
        } else {
            return new SimpleValueWrapper(oldValue);
        }
    }

    @Override
    public void evict(Object key) {
        cacheHandler.delete(toKey(key));
    }

    @Override
    public void clear() {
        logger.debug("clear {}", name);
        Set<String> keys = cacheHandler.smembers(CACHE_KEYS + name);
        String[] ks = new String[keys.size()];
        int index = 0;
        for (String k : keys) {
            ks[index++] = k;
        }
        cacheHandler.delete(null, ks);
    }

    private void setValue(String key, Object value) {
        cacheHandler.sadd(CACHE_KEYS + name, key);
        cacheHandler.setObject(key, value, cacheTime);
    }

    private String toKey(Object key) {
        return CACHE_KEY + name + '_' + key.toString();
    }
}

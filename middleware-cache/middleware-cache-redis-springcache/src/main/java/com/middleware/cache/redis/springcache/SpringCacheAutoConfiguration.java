package com.middleware.cache.redis.springcache;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.middleware.cache.core.CacheHandler;

/**
 * @author DOUBLE 2017-08-10
 */
@Configuration
@EnableCaching
public class SpringCacheAutoConfiguration {

    @Component
    public static class RedisCacheManager implements CacheManager, InitializingBean {
        public static final String CACHE_KEY = "SPRING_";
        public static final String CACHE_KEYS = CACHE_KEY + "KEYS_";

        private final Logger logger = LoggerFactory.getLogger(getClass());
        private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<>(16);
        private final CacheHandler cacheHandler;
        private Set<String> cacheNames = Collections.emptySet();
        @Value("${spring.cache.annotationCacheTime:7200}")
        private int cacheTime;

        @Autowired
        public RedisCacheManager(CacheHandler cacheHandler) {
            this.cacheHandler = cacheHandler;
        }

        @Override
        public Cache getCache(String name) {
            Cache cache = this.cacheMap.get(name);
            if (cache != null) {
                return cache;
            } else {
                synchronized (this.cacheMap) {
                    cache = this.cacheMap.get(name);
                    if (cache == null) {
                        cache = new RedisCacheImpl(cacheHandler, name, cacheTime);
                        this.cacheMap.put(name, cache);
                        updateCacheNames(name);
                    }
                    return cache;
                }
            }
        }

        @Override
        public Collection<String> getCacheNames() {
            return this.cacheNames;
        }

        private void updateCacheNames(String name) {
            Set<String> cms = new LinkedHashSet<>(this.cacheNames.size() + 1);
            cms.addAll(this.cacheNames);
            cms.add(name);
            this.cacheNames = Collections.unmodifiableSet(cms);
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    cacheNames.forEach(name -> {
                        logger.trace("reset expire {}{}", CACHE_KEYS, name);
                        cacheHandler.expire(CACHE_KEYS + name, cacheTime);
                    });
                    logger.debug("reset expire");
                }
            };
            timer.scheduleAtFixedRate(task, cacheTime * 350L, cacheTime * 350L);
            logger.info("spring cache expire is start. cacheTime={}", cacheTime);
        }
    }
}

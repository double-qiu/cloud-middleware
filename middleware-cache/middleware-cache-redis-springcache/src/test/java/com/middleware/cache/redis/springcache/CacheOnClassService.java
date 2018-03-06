package com.middleware.cache.redis.springcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Cacheable("service2")
@Service
public class CacheOnClassService extends AbstractService {
    private TestBean current;

    public void save(TestBean bean) {
        logger.info("save:" + bean);
        this.current = bean;
    }

    public TestBean get(Integer id) {
        logger.info("get: " + id);
        return current;
    }

    public void delete(Integer id) {
        logger.info("delete:" + id);
        current = null;
    }
}

package com.middleware.cache.redis.springcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Cacheable
@Service
public class CacheNoNameService extends AbstractService {
    private TestBean current;

    @CachePut
    public void save(TestBean bean) {
        logger.info("save:" + bean);
        this.current = bean;
    }

    @Cacheable
    public TestBean get(Integer id) {
        logger.info("get: " + id);
        return current;
    }

    @CacheEvict
    public void delete(Integer id) {
        logger.info("delete:" + id);
        current = null;
    }
}

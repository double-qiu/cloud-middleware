package com.middleware.cache.redis.springcache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "cache")
@Service
public class CacheService extends AbstractService {

    @CachePut(key = "#bean.queryId")
    public void save(TestBean bean) {
        logger.info("save:" + bean);
    }

    @Cacheable
    public TestBean get(Integer id) {
        logger.info("get: " + id);
        return toBean(id);
    }

    @CacheEvict
    public void delete(Integer id) {
        logger.info("delete:" + id);
    }

    private TestBean toBean(Integer id) {
        TestBean test = new TestBean();
        test.setUserName("test userName");
        test.setLoginName("test loginName");
        test.setQueryId(id);
        return test;
    }
}



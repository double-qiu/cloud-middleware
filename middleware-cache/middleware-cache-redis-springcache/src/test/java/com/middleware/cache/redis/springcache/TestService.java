package com.middleware.cache.redis.springcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author DOUBLE 2017-08-25
 */
@SuppressWarnings("unused")
@Component
public class TestService {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private CacheNoNameService cacheNoNameService;
	@Autowired
    private CacheOnClassService cacheOnClassService;

    public void cache() {
        cacheService.get(1);
        cacheService.get(1);
        cacheService.save(cacheBean());
        cacheService.save(cacheBean());
        cacheService.get(1);
        cacheService.save(cacheBean());
        cacheService.get(1);
        cacheService.delete(1);
        cacheService.get(1);
        cacheService.get(1);
        cacheService.get(1);
        cacheService.get(2);
        cacheService.get(2);
        cacheService.get(2);
        cacheService.delete(2);

    }

    private TestBean cacheBean() {
        TestBean bean = new TestBean();
        bean.setLoginName("cache loginName");
        bean.setUserName("cache userName");
        bean.setQueryId(5);
        return bean;
    }

    public void test() {
        cache();
    }

}

package com.middleware.cache.redis.autoconfigure;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.middleware.cache.core.CacheHandler;
import com.middleware.cache.core.L2CacheHandler;

/**
 * @author DOUBLE 2017-08-25
 */
@Component
public class CacheHandlerService {
	@SuppressWarnings("unused")
	@Autowired
	private CacheHandler cacheHandler;
	@Autowired
	private L2CacheHandler l2CacheHander;

	public void test() {
		Map<String, Object> data = new HashMap<>();
		data.put("key", "zz");
		data.put("value", "bbz");
		l2CacheHander.lpush("3222:3:63", 50000, data);
//		l2CacheHander.set("aa", data);
		System.out.println(l2CacheHander.getL2("aa", Map.class));
//		for (int i = 0; i < 1000; i++) {
//			data.put("i", i);
//			l2CacheHander.deleteL2("aa");
//			l2CacheHander.set("aa", data);
//			System.out.println(l2CacheHander.getL2("aa", Map.class));
//		}
	}
}

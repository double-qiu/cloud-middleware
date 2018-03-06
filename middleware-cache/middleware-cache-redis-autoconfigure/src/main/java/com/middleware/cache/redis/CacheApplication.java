package com.middleware.cache.redis;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.middleware.cache.redis.autoconfigure.CacheHandlerService;

/**
 * @author DOUBLE 2017-08-20
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class CacheApplication {

	public static void main(String[] args) {
		ConfigurableListableBeanFactory factory = SpringApplication.run(CacheApplication.class, args).getBeanFactory();
		factory.getBean(CacheHandlerService.class).test();
	}
}

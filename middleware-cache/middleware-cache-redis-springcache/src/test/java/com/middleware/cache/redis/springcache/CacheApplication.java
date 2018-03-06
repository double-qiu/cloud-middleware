package com.middleware.cache.redis.springcache;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author DOUBLE 2017-08-20
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class CacheApplication {

	public static void main(String[] args) {
		ConfigurableListableBeanFactory factory = SpringApplication.run(CacheApplication.class, args).getBeanFactory();
		factory.getBean(TestService.class).test();
	}
}

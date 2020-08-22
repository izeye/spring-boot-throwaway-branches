package com.izeye.throwaway.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * Configuration for cache.
 *
 * @author Johnny Lim
 */
@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public Caffeine caffeine() {
		return Caffeine.newBuilder().recordStats();
	}

}

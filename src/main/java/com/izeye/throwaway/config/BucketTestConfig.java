package com.izeye.throwaway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.izeye.throwaway.repository.YamlBucketTestRepository;

/**
 * Configuration for {@link com.izeye.throwaway.domain.BucketTest}.
 *
 * @author Johnny Lim
 */
@Configuration
public class BucketTestConfig {

	@Bean
	// FIXME: 'locations' has been deprecated, so it should be replaced with what?
//	@ConfigurationProperties(locations = "classpath:/repository/bucket/bucket.yml")
	@ConfigurationProperties
	public YamlBucketTestRepository bucketTestRepository() {
		return new YamlBucketTestRepository();
	}

}

package com.izeye.throwaway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * First Elasticsearch configuration.
 *
 * @author Johnny Lim
 */
@Configuration
public class FirstElasticsearchConfig {

	@Bean
	@ConfigurationProperties(prefix = "app.first-elasticsearch")
	public TransportClientFactoryBean firstTransportClient() {
		return new TransportClientFactoryBean();
	}

}

package com.izeye.throwaway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Second Elasticsearch configuration.
 *
 * @author Johnny Lim
 */
@Configuration
public class SecondElasticsearchConfig {

	@Bean
	@ConfigurationProperties(prefix = "app.second-elasticsearch")
	public TransportClientFactoryBean secondTransportClient() {
		return new TransportClientFactoryBean();
	}

}

package com.izeye.throwaway.config;

import com.izeye.throwaway.support.elasticsearch.TransportClientFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 15. 11. 19..
 */
@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticsearchConfiguration {
	
	@Autowired
	private ElasticsearchProperties properties;
	
	@Bean
	public TransportClientFactoryBean elasticsearchClient() {
		TransportClientFactoryBean factoryBean = new TransportClientFactoryBean();
		factoryBean.setClusterName(properties.getClusterName());
		factoryBean.setClusterNodes(properties.getClusterNodes());
		return factoryBean;
	}
	
}

package com.izeye.throwaway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by izeye on 15. 11. 19..
 */
@Data
@ConfigurationProperties(prefix = "app.elasticsearch")
public class ElasticsearchProperties {
	
	private String clusterName = "elasticsearch";
	
	private String clusterNodes;
	
}

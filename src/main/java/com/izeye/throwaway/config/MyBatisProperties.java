package com.izeye.throwaway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

/**
 * Created by izeye on 15. 2. 22..
 */
@ConfigurationProperties(prefix = "mybatis")
public class MyBatisProperties {

	private Resource configLocation;
	private Resource[] mapperLocations;

	public Resource getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	}

	public Resource[] getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(Resource[] mapperLocations) {
		this.mapperLocations = mapperLocations;
	}

}

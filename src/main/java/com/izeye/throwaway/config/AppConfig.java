package com.izeye.throwaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 16. 7. 18..
 */
@Configuration
public class AppConfig {
	
	@Bean
	public PrototypeObjectFactoryBean prototypeObject() {
		return new PrototypeObjectFactoryBean();
	}
	
}

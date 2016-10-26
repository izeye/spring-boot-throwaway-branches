package com.izeye.throwaway.config;

import com.izeye.throwaway.service.DefaultPersonServiceConsumer;
import com.izeye.throwaway.service.PersonServiceConsumer;
import com.izeye.throwaway.service.SomeService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 16. 4. 4..
 */
@Configuration
public class AppConfig {
	
	@Bean
	public PersonServiceConsumer personServiceConsumer() {
		return new DefaultPersonServiceConsumer();
	}
	
	@Bean
	public SingletonObjectFactoryBean singletonObject() {
		return new SingletonObjectFactoryBean();
	}
	
	@Bean
	public PrototypeObjectFactoryBean prototypeObject() {
		return new PrototypeObjectFactoryBean();
	}

	@Bean
	public SomeService someService() {
		return new SomeService();
	}
	
}

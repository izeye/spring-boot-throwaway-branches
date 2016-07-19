package com.izeye.throwaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by izeye on 16. 7. 18..
 */
@Configuration
public class AppConfig {
	
	@Bean
	public PrototypeObjectFactoryBean prototypeObject() {
		return new PrototypeObjectFactoryBean();
	}
	
	@Bean
	public SmartPrototypeObjectFactoryBean smartPrototypeObject() {
		return new SmartPrototypeObjectFactoryBean();
	}
	
	@Bean
	@Scope(scopeName = "prototype")
	public AnotherPrototypeObject anotherPrototypeObject() {
		return new AnotherPrototypeObject();
	}
	
	@Bean
	public SingletonObject singletonObject() {
		return new SingletonObject();
	}
	
}

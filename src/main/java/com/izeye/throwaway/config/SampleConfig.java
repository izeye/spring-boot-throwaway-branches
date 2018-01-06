package com.izeye.throwaway.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sample {@link Configuration}.
 *
 * @author Johnny Lim
 */
@Configuration
public class SampleConfig {

	@Bean
	public Person person() {
		return new Person();
	}

	@PostConstruct
	public void init() {
		System.out.println(person() == person());
	}

	static class Person {
	}

}

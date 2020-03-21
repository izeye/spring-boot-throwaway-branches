package com.izeye.throwaway.config.noscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.izeye.throwaway.domain.Person;

@Configuration
public class NoScanConfig {

	@Bean
	public Person noScanPerson() {
		return new Person();
	}

}

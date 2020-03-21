package com.izeye.throwaway.config.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.izeye.throwaway.domain.Person;

/**
 * Sample {@link Configuration}.
 *
 * @author Johnny Lim
 */
@Configuration
public class ScanConfig {

	@Bean
	public Person scanPerson() {
		return new Person();
	}

}

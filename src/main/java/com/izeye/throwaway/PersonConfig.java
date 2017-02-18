package com.izeye.throwaway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link Person}.
 *
 * @author Johnny Lim
 */
@Configuration
public class PersonConfig {

	@Bean
	@ConfigurationProperties
	public Person person() {
		return new Person();
	}

	@Bean
	@ConfigurationProperties(prefix = "some")
	public Person somePerson() {
		return new Person();
	}

}

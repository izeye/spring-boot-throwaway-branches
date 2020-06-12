package com.izeye.throwaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * {@link Configuration} having a nested configuration class with {@code static-inner} profile.
 *
 * @author Johnny Lim
 */
@Configuration
public class NestedProfileConfig {

	@Bean
	public String stringInNestedProfileConfig() {
		return "string";
	}

	@Configuration
	@Profile("static-inner")
	public static class NestedConfiguration {

		@Bean
		public Integer integerInNestedProfileConfig() {
			return Integer.MAX_VALUE;
		}

	}

}

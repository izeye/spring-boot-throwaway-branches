package com.izeye.throwaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * {@link Configuration} with {@code test} profile having a nested configuration class
 * with {@code nested} profile.
 *
 * @author Johnny Lim
 */
@Configuration
@Profile("test")
public class ProfileNestedProfileConfig {

	@Bean
	public String stringInProfileNestedProfileConfig() {
		return "string";
	}

	@Configuration
	@Profile("nested")
	public static class NestedConfiguration {

		@Bean
		public Integer integerInProfileNestedProfileConfig() {
			return Integer.MAX_VALUE;
		}

	}
}

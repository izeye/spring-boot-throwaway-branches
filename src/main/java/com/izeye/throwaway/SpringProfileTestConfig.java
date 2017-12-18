package com.izeye.throwaway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration for Spring profile tests.
 *
 * @author Johnny Lim
 */
@Configuration
public class SpringProfileTestConfig {

	@Profile("profile1")
	@Bean
	public String beanForProfile1() {
		return "profile1";
	}

	@Profile("!profile1")
	@Bean
	public String beanForNonProfile1() {
		return "!profile1";
	}

	@Profile({"!profile1", "profile2"})
	@Bean
	public String beanForNonProfile1OrProfile2() {
		return "!profile1 or profile2";
	}

}

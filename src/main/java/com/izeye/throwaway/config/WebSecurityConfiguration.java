package com.izeye.throwaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Configuration for web security.
 *
 * @author Johnny Lim
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new InMemoryUserDetailsManager(
				User.withUsername("user").password("password")
						.authorities("ROLE_USER")
						.passwordEncoder(passwordEncoder::encode).build(),
				User.withUsername("admin").password("admin")
						.authorities("ROLE_ACTUATOR", "ROLE_ADMIN", "ROLE_USER")
						.passwordEncoder(passwordEncoder::encode).build()
		);
	}

}

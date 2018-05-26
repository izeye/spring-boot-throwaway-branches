package com.izeye.throwaway;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * {@link Configuration} for security.
 *
 * @author Johnny Lim
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().regexMatchers("/persons").authenticated()
				.and().httpBasic()
				.and().csrf().disable();
	}

}

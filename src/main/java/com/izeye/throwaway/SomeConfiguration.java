package com.izeye.throwaway;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Sample {@link Configuration}.
 *
 * @author Johnny Lim
 */
@Configuration
public class SomeConfiguration {

	@Value("${SOME_ENVIRONMENT_VARIABLE:false}")
	private boolean someEnvironmentVariable;

	@PostConstruct
	public void init() {
		System.out.println(this.someEnvironmentVariable);
	}

}

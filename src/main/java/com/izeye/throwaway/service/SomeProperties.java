package com.izeye.throwaway.service;

import javax.validation.constraints.Pattern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * {@link ConfigurationProperties} for {@link SomeService}.
 *
 * @author Johnny Lim
 */
@ConfigurationProperties("some")
@Validated
public class SomeProperties {

	/**
	 * Token ("username:password").
	 */
	@Pattern(regexp = "\\w+:\\w+")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

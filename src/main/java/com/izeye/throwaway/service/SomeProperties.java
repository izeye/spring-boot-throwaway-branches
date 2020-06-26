package com.izeye.throwaway.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@link ConfigurationProperties} for {@link SomeService}.
 *
 * @author Johnny Lim
 */
@ConfigurationProperties("some")
public class SomeProperties {

	/**
	 * Token.
	 */
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

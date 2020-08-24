package com.izeye.throwaway.service;

import org.springframework.stereotype.Service;

/**
 * Default {@link SomeService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultSomeService implements SomeService {

	private final SomeProperties properties;

	public DefaultSomeService(SomeProperties properties) {
		this.properties = properties;
	}

	@Override
	public void doService() {
	}

}

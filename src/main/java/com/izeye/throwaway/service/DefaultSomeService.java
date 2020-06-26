package com.izeye.throwaway.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * Default {@link SomeService}.
 *
 * @author Johnny Lim
 */
@Service
@EnableConfigurationProperties(SomeProperties.class)
public class DefaultSomeService implements SomeService {

	@Override
	public void doService() {
	}

}

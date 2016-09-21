package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Consumer for {@link TestService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultTestServiceConsumer implements TestServiceConsumer {

	@Autowired
	@Lazy
	private TestService testService;

	@Override
	public void consumeTestService() {
		this.testService.test();
	}

}

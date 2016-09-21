package com.izeye.throwaway.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Lazy version of {@link TestService}.
 *
 * @author Johnny Lim
 */

@Service
@Lazy
public class LazyTestService implements TestService {

	public static boolean initialized = false;

	public LazyTestService() {
		System.out.println("LazyTestService() invoked.");

		initialized = true;
	}

	@Override
	public void test() {
		System.out.println("test() invoked.");
	}

}

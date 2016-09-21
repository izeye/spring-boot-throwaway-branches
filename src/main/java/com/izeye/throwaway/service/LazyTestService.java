package com.izeye.throwaway.service;

/**
 * Lazy version of {@link TestService}.
 *
 * @author Johnny Lim
 */
@LazyService
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

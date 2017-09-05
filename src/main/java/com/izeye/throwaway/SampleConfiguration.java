package com.izeye.throwaway;

import org.springframework.context.annotation.Configuration;

/**
 * Sample {@link Configuration}.
 *
 * @author Johnny Lim
 */
@Configuration
public class SampleConfiguration {

	/**
	 * {@code private} access modifier on {@link Configuration} class worn't work.
	 */
	@Configuration
	static class SubSampleConfiguration {
	}

}

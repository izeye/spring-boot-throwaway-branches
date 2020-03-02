package com.izeye.throwaway.service;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests for {@link PathMatchingResourcePatternResolverService}.
 *
 * @author Johnny Lim
 */
public class PathMatchingResourcePatternResolverServiceTests {

	private final PathMatchingResourcePatternResolverService service = new PathMatchingResourcePatternResolverService();

	@Test
	public void test() throws IOException {
		this.service.init();
	}

}

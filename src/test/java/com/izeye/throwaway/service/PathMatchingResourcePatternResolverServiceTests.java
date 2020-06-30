package com.izeye.throwaway.service;

import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link PathMatchingResourcePatternResolverService}.
 *
 * @author Johnny Lim
 */
class PathMatchingResourcePatternResolverServiceTests {

	private final PathMatchingResourcePatternResolverService service = new PathMatchingResourcePatternResolverService();

	@Test
	void test() throws IOException {
		this.service.init();
	}

}

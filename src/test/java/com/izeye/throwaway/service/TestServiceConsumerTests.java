package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link TestServiceConsumer}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TestServiceConsumerTests {

	@Autowired
	private TestServiceConsumer testServiceConsumer;

	@Test
	void testLazy() {
		assertThat(this.testServiceConsumer).isNotNull();
		assertThat(LazyTestService.initialized).isFalse();

		this.testServiceConsumer.consumeTestService();
		assertThat(LazyTestService.initialized).isTrue();
	}

}

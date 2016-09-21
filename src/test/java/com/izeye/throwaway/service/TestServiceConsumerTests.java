package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link TestServiceConsumer}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestServiceConsumerTests {

	@Autowired
	private TestServiceConsumer testServiceConsumer;

	@Test
	public void testLazy() {
		assertThat(this.testServiceConsumer).isNotNull();
		assertThat(LazyTestService.initialized).isFalse();

		this.testServiceConsumer.consumeTestService();
		assertThat(LazyTestService.initialized).isTrue();
	}

}

package com.izeye.throwaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SamplePrototypeScopeBean}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class SamplePrototypeScopeBeanTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void getBean() {
		assertThat(this.applicationContext.getBean(SamplePrototypeScopeBean.class))
				.isNotSameAs(this.applicationContext.getBean(SamplePrototypeScopeBean.class));
	}

}

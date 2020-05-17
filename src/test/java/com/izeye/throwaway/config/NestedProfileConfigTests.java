package com.izeye.throwaway.config;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link NestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class NestedProfileConfigTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void test() {
		assertThat(this.applicationContext.getBean("stringInNestedProfileConfig"))
				.isEqualTo("string");

		assertThatThrownBy(() -> this.applicationContext.getBean("integerInNestedProfileConfig"))
				.isExactlyInstanceOf(NoSuchBeanDefinitionException.class);
	}

}

package com.izeye.throwaway.config;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests with {@code nested} nested profile for {@link ProfileNestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@ActiveProfiles("nested")
class ProfileNestedProfileConfigWithNestedProfileTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void testStringInProfileNestedProfileConfig() {
		assertThatThrownBy(() -> this.applicationContext.getBean("stringInProfileNestedProfileConfig"))
				.isExactlyInstanceOf(NoSuchBeanDefinitionException.class);
	}

	@Test
	void testIntegerInProfileNestedProfileConfig() {
		assertThatThrownBy(() -> this.applicationContext.getBean("integerInProfileNestedProfileConfig"))
				.isExactlyInstanceOf(NoSuchBeanDefinitionException.class);
	}

}

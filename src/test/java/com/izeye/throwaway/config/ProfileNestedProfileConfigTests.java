package com.izeye.throwaway.config;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests with {@code test} profile for {@link ProfileNestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@ActiveProfiles("test")
class ProfileNestedProfileConfigTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void test() {
		assertThat(this.applicationContext.getBean("stringInProfileNestedProfileConfig"))
				.isEqualTo("string");

		assertThatThrownBy(() -> this.applicationContext.getBean("integerInProfileNestedProfileConfig"))
				.isExactlyInstanceOf(NoSuchBeanDefinitionException.class);
	}

}

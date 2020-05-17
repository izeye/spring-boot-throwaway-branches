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
 * Tests with {@code static-nested} nested profile for {@link ProfileNestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@ActiveProfiles("static-nested")
class ProfileNestedProfileConfigWithStaticNestedProfileTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void test() {
		assertThat(this.applicationContext.getBean("integerInProfileNestedProfileConfig"))
				.isEqualTo(Integer.MAX_VALUE);

		assertThatThrownBy(() -> this.applicationContext.getBean("stringInProfileNestedProfileConfig"))
				.isExactlyInstanceOf(NoSuchBeanDefinitionException.class);
	}

}

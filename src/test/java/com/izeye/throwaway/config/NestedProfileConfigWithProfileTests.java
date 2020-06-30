package com.izeye.throwaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests with {@code static-inner} profile for {@link NestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("static-inner")
class NestedProfileConfigWithProfileTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void test() {
		assertThat(this.applicationContext.getBean("stringInNestedProfileConfig"))
				.isEqualTo("string");
		assertThat(this.applicationContext.getBean("integerInNestedProfileConfig"))
				.isEqualTo(Integer.MAX_VALUE);
	}

}

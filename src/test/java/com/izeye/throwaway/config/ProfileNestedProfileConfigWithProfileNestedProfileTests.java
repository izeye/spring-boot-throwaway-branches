package com.izeye.throwaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests with {@code test} profile and {@code nested} nested profile
 * for {@link ProfileNestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles({ "test", "nested" })
class ProfileNestedProfileConfigWithProfileNestedProfileTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void test() {
		assertThat(this.applicationContext.getBean("stringInProfileNestedProfileConfig"))
				.isEqualTo("string");
		assertThat(this.applicationContext.getBean("integerInProfileNestedProfileConfig"))
				.isEqualTo(Integer.MAX_VALUE);
	}

}

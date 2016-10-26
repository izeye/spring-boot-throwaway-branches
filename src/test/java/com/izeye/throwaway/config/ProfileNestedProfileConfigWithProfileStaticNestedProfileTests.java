package com.izeye.throwaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests with {@code test} profile and {@code static-nested} nested profile
 * for {@link ProfileNestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles({ "test", "static-nested" })
public class ProfileNestedProfileConfigWithProfileStaticNestedProfileTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void test() {
		assertThat(this.applicationContext.getBean("stringInProfileNestedProfileConfig"))
				.isEqualTo("string");
		assertThat(this.applicationContext.getBean("integerInProfileNestedProfileConfig"))
				.isEqualTo(Integer.MAX_VALUE);
	}

}

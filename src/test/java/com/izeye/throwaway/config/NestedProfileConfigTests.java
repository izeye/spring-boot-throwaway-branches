package com.izeye.throwaway.config;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link NestedProfileConfig}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NestedProfileConfigTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void test() {
		assertThat(this.applicationContext.getBean("stringInNestedProfileConfig"))
				.isEqualTo("string");

		this.thrown.expect(NoSuchBeanDefinitionException.class);
		this.applicationContext.getBean("integerInNestedProfileConfig");
	}

}

package com.izeye.throwaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SamplePrototypeScopeBean}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SamplePrototypeScopeBeanTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void getBean() {
		assertThat(this.applicationContext.getBean(SamplePrototypeScopeBean.class))
				.isNotSameAs(this.applicationContext.getBean(SamplePrototypeScopeBean.class));
	}

}

package com.izeye.throwaway;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SpringProfileTestConfig} with {@literal profile2}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"profile1", "profile2"})
public class SpringProfileTestConfigProfile1AndProfile2Tests {

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Autowired
	private ApplicationContext context;

	@Test
	public void testBeanForProfile1() {
		assertThat(this.context.getBean("beanForProfile1")).isEqualTo("profile1");
	}

	@Test
	public void testBeanForNonProfile1() {
		this.thrown.expect(NoSuchBeanDefinitionException.class);
		this.context.getBean("beanForNonProfile1");
	}

	@Test
	public void testBeanForNonProfile1OrProfile2() {
		assertThat(this.context.getBean("beanForNonProfile1OrProfile2")).isEqualTo("!profile1 or profile2");
	}

}

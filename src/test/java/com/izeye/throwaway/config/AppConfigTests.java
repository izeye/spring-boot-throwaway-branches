package com.izeye.throwaway.config;

import com.izeye.throwaway.service.DefaultPersonServiceConsumer;
import com.izeye.throwaway.service.PersonServiceConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 4..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AppConfigTests {
	
	@Autowired
	PersonServiceConsumer personServiceConsumer;

	@Autowired
	ApplicationContext context;
	
	@Test
	public void test() {
		assertThat(((DefaultPersonServiceConsumer) personServiceConsumer).getPersonService())
				.isNotNull();
	}

	@Test
	public void testNullBean() {
		Object nullBean = this.context.getBean("nullBean");

		assertThat(nullBean).isNotNull();
		assertThat(nullBean).isEqualTo(null);
	}
	
}

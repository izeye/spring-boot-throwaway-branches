package com.izeye.throwaway.config;

import com.izeye.throwaway.Application;
import com.izeye.throwaway.service.DefaultPersonServiceConsumer;
import com.izeye.throwaway.service.PersonServiceConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 4..
 */
@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AppConfigTests {
	
	@Autowired
	PersonServiceConsumer personServiceConsumer;
	
	@Test
	public void test() {
		assertThat(((DefaultPersonServiceConsumer) personServiceConsumer).getPersonService())
				.isNotNull();
	}
	
}

package com.izeye.throwaway.person.service;

import com.izeye.throwaway.Application;
import com.izeye.throwaway.service.DefaultPersonService;
import com.izeye.throwaway.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 1..
 */
@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PersonServiceTests {
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testGetFinalMessage() {
		String finalMessage = ((DefaultPersonService) personService).getFinalMessage();
		System.out.println(finalMessage);
		assertThat(finalMessage).isNull();
	}
	
}

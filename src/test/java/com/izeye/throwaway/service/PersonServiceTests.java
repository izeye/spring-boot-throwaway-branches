package com.izeye.throwaway.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 1..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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

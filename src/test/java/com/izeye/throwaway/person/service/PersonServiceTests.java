package com.izeye.throwaway.person.service;

import com.izeye.throwaway.service.DefaultPersonService;
import com.izeye.throwaway.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 1..
 */
@SpringBootTest(properties = "spring.cache.type=simple")
class PersonServiceTests {
	
	@Autowired
	PersonService personService;
	
	@Test
	void testGetFinalMessage() {
		String finalMessage = ((DefaultPersonService) personService).getFinalMessage();
		System.out.println(finalMessage);
		assertThat(finalMessage).isNull();
	}
	
}

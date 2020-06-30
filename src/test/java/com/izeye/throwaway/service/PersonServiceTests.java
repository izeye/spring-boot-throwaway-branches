package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonService}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class PersonServiceTests {
	
	@Autowired
	private PersonService personService;
	
	@Test
	void testGetMessage() {
		assertThat(this.personService.getMessage()).isEqualTo("Hello, world!");
	}
	
}

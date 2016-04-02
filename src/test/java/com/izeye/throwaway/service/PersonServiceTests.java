package com.izeye.throwaway.service;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PersonServiceTests {
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testGetPerson() {
		assertThat(personService.getPerson())
				.isNotSameAs(personService.getPerson());
	}

	@Test
	public void testGetPersonWithInterfaceCacheable() {
		assertThat(personService.getPersonWithInterfaceCacheable())
				.isSameAs(personService.getPersonWithInterfaceCacheable());
	}

	@Test
	public void testGetPersonWithClassCacheable() {
		assertThat(personService.getPersonWithClassCacheable())
				.isSameAs(personService.getPersonWithClassCacheable());
	}
	
}

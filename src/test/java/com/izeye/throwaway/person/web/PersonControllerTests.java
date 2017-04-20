package com.izeye.throwaway.person.web;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.domain.TestDomainFactory;
import com.izeye.throwaway.person.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Tests for {@link PersonController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTests {
	
	@MockBean
	PersonService personService;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Before
	public void setUp() {
		given(this.personService.findAll())
				.willReturn(Collections.singletonList(TestDomainFactory.createPerson()));

		String firstName = "John";
		Person person = new Person();
		person.setFirstName(firstName);
		given(this.personService.findByFirstName(firstName))
				.willReturn(person);
	}

	@Test
	public void testGetAllWithStringResponse() {
		String response = this.restTemplate.getForObject("/persons", String.class);
		System.out.println(response);
	}

	@Test
	public void testGetAllWithTypedResponse() {
		ResponseEntity<List<Person>> response = this.restTemplate.exchange(
				"/persons", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Person>>() {});
		List<Person> persons = response.getBody();
		System.out.println(persons);
		assertThat(persons.size()).isEqualTo(1);
		
		Person person = persons.get(0);
		assertThat(person.getId()).isNotNull();
		assertThat(person.getFirstName()).isNotNull();
		assertThat(person.getLastName()).isNotNull();
		assertThat(person.getAge()).isNotNull();
		assertThat(person.getCreatedTime()).isNotNull();
	}
	
	@Test
	public void testGetByFirstName() {
		String firstName = "John";
		
		Person person = this.restTemplate.getForObject(
				"/persons/{firstName}", Person.class, firstName);
		System.out.println(person);
		assertThat(person.getFirstName()).isEqualTo(firstName);
	}
	
}

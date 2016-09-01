package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by izeye on 15. 10. 1..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGetAllWithStringResponse() {
		String url = "/persons";
		String response = this.restTemplate.getForObject(url, String.class);
		System.out.println(response);
	}

	@Test
	public void testGetAllWithTypedResponse() {
		String url = "/persons";
		ResponseEntity<List<Person>> response = this.restTemplate.exchange(
				url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {});
		List<Person> persons = response.getBody();
		System.out.println(persons);
		assertThat(persons.size(), is(1));
		
		Person person = persons.get(0);
		assertThat(person.getId(), is(notNullValue()));
		assertThat(person.getName().getFirstName(), is(notNullValue()));
		assertThat(person.getName().getLastName(), is(notNullValue()));
		assertThat(person.getAge(), is(notNullValue()));
		assertThat(person.getCreatedTime(), is(notNullValue()));
	}
	
}

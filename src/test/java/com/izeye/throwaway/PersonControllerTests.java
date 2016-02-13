package com.izeye.throwaway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by izeye on 15. 10. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest(randomPort = true)
public class PersonControllerTests {
	
	@Value("${local.server.port}")
	int port;
	
	@Value("${security.user.name}")
	String username;
	
	@Value("${security.user.password}")
	String password;
	
	@Autowired
	ObjectMapper objectMapper;

	RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		this.restTemplate = new TestRestTemplate(username, password);
		for (HttpMessageConverter<?> messageConverter : this.restTemplate.getMessageConverters()) {
			if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
				MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter
						= (MappingJackson2HttpMessageConverter) messageConverter;
				mappingJackson2HttpMessageConverter.setObjectMapper(this.objectMapper);
			}
		}
	}
	
	@Test
	public void testGetAllWithStringResponse() {
		String url = "http://localhost:{port}/api/persons";
		String response = this.restTemplate.getForObject(url, String.class, this.port);
		System.out.println(response);
	}

	@Test
	public void testGetAllWithTypedResponse() {
		String url = "http://localhost:{port}/api/persons";
		ResponseEntity<List<Person>> response = this.restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Person>>() {}, this.port);
		List<Person> persons = response.getBody();
		System.out.println(persons);
		assertThat(persons.size(), is(1));
		
		Person person = persons.get(0);
		assertThat(person.getId(), is(notNullValue()));
		assertThat(person.getFirstName(), is(notNullValue()));
		assertThat(person.getLastName(), is(notNullValue()));
		assertThat(person.getAge(), is(notNullValue()));
		assertThat(person.getCreatedTime(), is(notNullValue()));
	}
	
}

package com.izeye.throwaway;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by izeye on 15. 12. 28..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest(randomPort = true)
public class ApplicationTests {
	
	@Value("${local.server.port}")
	int port;
	
	@Autowired
	PersonRepository personRepository;
	
	RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setFavoriteFruit(Fruit.APPLE);
		personRepository.save(person);

		restTemplate = createRestTemplate();
	}

	private RestTemplate createRestTemplate() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new Jackson2HalModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);
		return new RestTemplate(Arrays.<HttpMessageConverter<?>> asList(converter));
	}
	
	@Test
	public void test() {
		ResponseEntity<PagedResources<Fruit>> fruits = restTemplate.exchange("http://localhost:{port}/fruits/with-resources", HttpMethod.GET, null, new ParameterizedTypeReference<PagedResources<Fruit>>() {
		}, port);
		System.out.println(fruits);
		
		ResponseEntity<PagedResources<Person>> persons = restTemplate.exchange("http://localhost:{port}/persons/search/findByFavoriteFruit?favorite_fruit=APPLE", HttpMethod.GET, null, new ParameterizedTypeReference<PagedResources<Person>>() {
		}, port);
		System.out.println(persons);
		
		// FIXME: NPE
//		fruits = restTemplate.exchange("http://localhost:{port}/fruits/with-resources", HttpMethod.GET, null, new ParameterizedTypeReference<PagedResources<Fruit>>() {
//		}, port);
//		System.out.println(fruits);
	}
	
}

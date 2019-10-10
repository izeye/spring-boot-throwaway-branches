package com.izeye.throwaway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RestTemplate}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTests {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void assertHttpMessageConverters() {
		assertHttpMessageConverters(this.restTemplate);
		assertHttpMessageConverters(this.testRestTemplate.getRestTemplate());

		// NOTE: XML is preferred over JSON for some reason.
//		assertHttpMessageConverters(new RestTemplate());
	}

	private void assertHttpMessageConverters(RestTemplate restTemplate) {
		List<HttpMessageConverter<?>> httpMessageConverters = restTemplate.getMessageConverters();
		Integer indexOfMappingJackson2HttpMessageConverter = null;
		Integer indexOfMappingJackson2XmlHttpMessageConverter = null;
		for (int i = 0; i < httpMessageConverters.size(); i++) {
			HttpMessageConverter<?> httpMessageConverter = httpMessageConverters.get(i);
			if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
				indexOfMappingJackson2HttpMessageConverter = i;
			}
			if (httpMessageConverter instanceof MappingJackson2XmlHttpMessageConverter) {
				indexOfMappingJackson2XmlHttpMessageConverter = i;
			}
		}
		assertThat(indexOfMappingJackson2HttpMessageConverter)
				.isLessThan(indexOfMappingJackson2XmlHttpMessageConverter);
	}

}

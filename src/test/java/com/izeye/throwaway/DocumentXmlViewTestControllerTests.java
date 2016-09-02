package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for {@link DocumentXmlViewTestController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocumentXmlViewTestControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testPersonsWithStringResponse() {
		String url = "/test/xml/persons";
		String response = this.restTemplate.getForObject(url, String.class);
		System.out.println(response);
	}

}

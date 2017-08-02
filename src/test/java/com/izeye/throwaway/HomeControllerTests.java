package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link HomeController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testHelloWorld() {
		String message = this.restTemplate.getForObject("/hello-world", String.class);
		assertThat(message).isEqualTo("Hello, world!");
	}

}

package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link HomeController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testHelloWorld() {
		String message = this.restTemplate.getForObject("/hello-world", String.class);
		assertThat(message).isEqualTo("Hello, world!");
	}

}

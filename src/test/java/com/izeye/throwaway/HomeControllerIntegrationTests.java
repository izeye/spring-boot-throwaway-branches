package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for {@link HomeController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerIntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testHelloWorld() {
		String message = this.restTemplate.getForObject("/hello-world", String.class);
		assertThat(message).isEqualTo("Hello, world!");
	}

	@Test
	void testEcho() {
		// NOTE: Check reserved character ',' is okay in parameter value.
		// See https://tools.ietf.org/html/rfc3986#section-2.2
		assertThat(this.restTemplate.getForObject("/echo?value={a},{b}", String.class, "hello", "world"))
				.isEqualTo(this.restTemplate.getForObject("/echo?value={value}", String.class, "hello,world"));
	}

}

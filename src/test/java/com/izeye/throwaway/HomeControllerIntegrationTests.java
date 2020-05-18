package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.izeye.throwaway.web.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for {@link HomeController}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerIntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testHelloWorld() {
		String message = this.restTemplate.getForObject("/hello-world", String.class);
		assertThat(message).isEqualTo("Hello, world!");
	}

	@Test
	public void testEcho() {
		// NOTE: Check reserved character ',' is okay in parameter value.
		// See https://tools.ietf.org/html/rfc3986#section-2.2
		assertThat(this.restTemplate.getForObject("/echo?value={a},{b}", String.class, "hello", "world"))
				.isEqualTo(this.restTemplate.getForObject("/echo?value={value}", String.class, "hello,world"));
	}

}

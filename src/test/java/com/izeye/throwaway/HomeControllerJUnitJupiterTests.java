package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerJUnitJupiterTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testHelloWorld() {
		String message = this.restTemplate.getForObject("/hello-world", String.class);
		assertThat(message).isEqualTo("Hello, world!");
	}

}

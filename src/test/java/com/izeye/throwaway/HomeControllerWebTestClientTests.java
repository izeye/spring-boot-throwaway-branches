package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for {@link HomeController} with {@link WebTestClient}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerWebTestClientTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void test() {
		this.webTestClient.get().uri("/hello-world").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Hello, world!");
	}

}

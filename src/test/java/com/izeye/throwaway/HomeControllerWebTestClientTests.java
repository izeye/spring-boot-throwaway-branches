package com.izeye.throwaway;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.izeye.throwaway.web.HomeController;
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
	public void testHelloWorld() {
		this.webTestClient.get().uri("/hello-world").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Hello, world!");
	}

	@Test
	public void testEcho() throws UnsupportedEncodingException {
		String value = "테스트";
		String encodedValue = URLEncoder.encode(value, "UTF-8");

		String query = "value=" + encodedValue;

		MultiValueMap<String, String> parameterMap = queryToMultiValueMap(query);

		this.webTestClient.get()
				.uri((uriBuilder) -> uriBuilder.path("/echo").queryParams(parameterMap).build()).exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(value);
	}

	private MultiValueMap<String, String> queryToMultiValueMap(String query) throws UnsupportedEncodingException {
		MultiValueMap<String, String> parameterMap = new LinkedMultiValueMap<>();
		String[] parameters = query.split("&");
		for (String parameter : parameters) {
			String[] pair = parameter.split("=");
			if (pair.length == 2) {
				parameterMap.add(pair[0], URLDecoder.decode(pair[1], "UTF-8"));
			}
		}
		return parameterMap;
	}

}

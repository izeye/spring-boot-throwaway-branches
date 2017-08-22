package com.izeye.throwaway;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RestTemplateBuilder}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateBuilderClientHttpRequestFactoryTests {

	private RestTemplate simpleRestTemplate;
	private RestTemplate httpComponentsRestTemplate;
	private RestTemplate httpComponentsRestTemplateWithNoConnectionReuseStrategy;

	@LocalServerPort
	private int port;

	@Autowired
	public void customizeSimpleRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

		this.simpleRestTemplate = restTemplateBuilder.requestFactory(requestFactory).build();
	}

	@Autowired
	public void customizeHttpComponentsRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

		this.httpComponentsRestTemplate = restTemplateBuilder.requestFactory(requestFactory).build();
	}

	@Autowired
	public void customizeHttpComponentsRestTemplateWithNoConnectionReuseStrategy(
			RestTemplateBuilder restTemplateBuilder) {
		CloseableHttpClient httpClient = HttpClientBuilder.create()
				.setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE).build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

		this.httpComponentsRestTemplateWithNoConnectionReuseStrategy = restTemplateBuilder
				.requestFactory(requestFactory).build();
	}

	@Test
	public void testSimple() {
		ResponseEntity<String> responseEntity = sendGetRequestWithAcceptEncodingGzip(
				this.simpleRestTemplate, new ParameterizedTypeReference<String>() {});

		// NOTE: This means GZIP won't work.
		assertThat(responseEntity.getHeaders().get(HttpHeaders.CONTENT_ENCODING)).contains("gzip");
	}

	@Test
	public void testHttpComponents() {
		ResponseEntity<Map<String, String>> responseEntity = sendGetRequestWithAcceptEncodingGzip(
				this.httpComponentsRestTemplate, new ParameterizedTypeReference<Map<String, String>>() {});
		assertThat(responseEntity.getHeaders().get(HttpHeaders.CONTENT_ENCODING)).isNull();
		assertThat(responseEntity.getBody().get(HttpHeaders.CONNECTION.toLowerCase())).isEqualTo("Keep-Alive");
	}

	@Test
	public void testHttpComponentsRestTemplateWithNoConnectionReuseStrategy() {
		ResponseEntity<Map<String, String>> responseEntity = sendGetRequestWithAcceptEncodingGzip(
				this.httpComponentsRestTemplateWithNoConnectionReuseStrategy,
				new ParameterizedTypeReference<Map<String, String>>() {});
		assertThat(responseEntity.getHeaders().get(HttpHeaders.CONTENT_ENCODING)).isNull();

		// NOTE: Expected "Close" but was "Keep-Alive".
		assertThat(responseEntity.getBody().get(HttpHeaders.CONNECTION.toLowerCase())).isEqualTo("Keep-Alive");
	}

	private <T> ResponseEntity<T> sendGetRequestWithAcceptEncodingGzip(
			RestTemplate restTemplate, ParameterizedTypeReference<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCEPT_ENCODING, "gzip");

		String url = "http://localhost:" + port + "/headers";
		URI uri = UriComponentsBuilder.fromHttpUrl(url).build().toUri();

		RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
		return restTemplate.exchange(requestEntity, responseType);
	}

}

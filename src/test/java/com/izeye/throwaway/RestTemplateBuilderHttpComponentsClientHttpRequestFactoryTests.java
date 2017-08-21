package com.izeye.throwaway;

import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
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
public class RestTemplateBuilderHttpComponentsClientHttpRequestFactoryTests {

	private RestTemplate defaultRestTemplate;
	private RestTemplate customRestTemplate;

	@Autowired
	public void useDefault(RestTemplateBuilder restTemplateBuilder) {
		this.defaultRestTemplate = restTemplateBuilder.build();
	}

	@Autowired
	public void customize(RestTemplateBuilder restTemplateBuilder) {
		CloseableHttpClient httpClient = HttpClientBuilder.create()
				.setMaxConnTotal(100).setMaxConnPerRoute(50).build();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		requestFactory.setConnectionRequestTimeout(1000);

		this.customRestTemplate = restTemplateBuilder.requestFactory(requestFactory).build();
	}

	@Test
	public void testDefaultRestTemplate() {
		int expectedMaxTotal = 10;
		int expectedDefaultMaxPerRoute = 5;
		Integer expectedConnectionRequestTimeout = null;
		assertConnectionPoolSettings(
				this.defaultRestTemplate, expectedMaxTotal, expectedDefaultMaxPerRoute,
				expectedConnectionRequestTimeout);
	}

	@Test
	public void testCustomRestTemplate() {
		int expectedMaxTotal = 100;
		int expectedDefaultMaxPerRoute = 50;
		int expectedConnectionRequestTimeout = 1000;
		assertConnectionPoolSettings(
				this.customRestTemplate, expectedMaxTotal, expectedDefaultMaxPerRoute,
				expectedConnectionRequestTimeout);
	}

	private void assertConnectionPoolSettings(
			RestTemplate restTemplate, int expectedMaxTotal, int expectedDefaultMaxPerRoute,
			Integer expectedConnectionRequestTimeout) {
		DirectFieldAccessor dfa = new DirectFieldAccessor(restTemplate);

		HttpComponentsClientHttpRequestFactory requestFactory = (HttpComponentsClientHttpRequestFactory) dfa.getPropertyValue("requestFactory");

		HttpClient httpClient = requestFactory.getHttpClient();
		dfa = new DirectFieldAccessor(httpClient);
		PoolingHttpClientConnectionManager connectionManager = (PoolingHttpClientConnectionManager) dfa.getPropertyValue("connManager");
		assertThat(connectionManager.getMaxTotal()).isEqualTo(expectedMaxTotal);
		assertThat(connectionManager.getDefaultMaxPerRoute()).isEqualTo(expectedDefaultMaxPerRoute);

		dfa = new DirectFieldAccessor(requestFactory);
		RequestConfig requestConfig = (RequestConfig) dfa.getPropertyValue("requestConfig");
		if (expectedConnectionRequestTimeout == null) {
			assertThat(requestConfig).isNull();
		}
		else {
			assertThat(requestConfig.getConnectionRequestTimeout()).isEqualTo(expectedConnectionRequestTimeout);
		}
	}

}

package learningtest.org.springframework.boot.web.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.izeye.throwaway.Application;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RestTemplateBuilder}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class
)
public class RestTemplateBuilderTests {

	@LocalServerPort
	private int port;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	private RestTemplate restTemplate;

	private boolean gzipExpected = false;

	@Before
	public void setUp() {
		HttpClient httpClient = HttpClientBuilder.create().addInterceptorFirst(
				new HttpResponseInterceptor() {
					@Override
					public void process(HttpResponse response, HttpContext context)
							throws HttpException, IOException {
						if (RestTemplateBuilderTests.this.gzipExpected) {
							String contentEncoding = response.getFirstHeader("Content-Encoding").getValue();
							assertThat(contentEncoding).isEqualTo("gzip");
						}
					}
				}).build();
		HttpComponentsClientHttpRequestFactory requestFactory =
				new HttpComponentsClientHttpRequestFactory(httpClient);
		this.restTemplate = this.restTemplateBuilder.requestFactory(requestFactory).build();
	}

	@Test
	public void test() {
		String message = "Hello, world!";

		String url = "http://localhost:" + this.port + "/echo?message={message}";

		String echoed = this.restTemplate.getForObject(url, String.class, message);
		assertThat(echoed).isEqualTo(message);
	}

	@Test
	public void testGzip() {
		this.gzipExpected = true;

		String url = "http://localhost:" + this.port + "/persons";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept-Encoding", "gzip");
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<String> response =
				this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		assertThat(response.getHeaders().get("Content-Encoding")).isNull();

		this.gzipExpected = false;
	}

}

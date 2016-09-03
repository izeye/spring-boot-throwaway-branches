package learningtest.org.springframework.boot.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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

	@Before
	public void setUp() {
		this.restTemplate = this.restTemplateBuilder.build();
	}

	@Test
	public void test() {
		String message = "Hello, world!";

		String url = "http://localhost:" + this.port + "/echo?message={message}";
		String echoed = restTemplate.getForObject(url, String.class, message);
		assertThat(echoed).isEqualTo(message);
	}

}

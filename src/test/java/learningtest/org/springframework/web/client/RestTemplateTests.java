package learningtest.org.springframework.web.client;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.izeye.throwaway.Application;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RestTemplate}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class
)
public class RestTemplateTests {

	@LocalServerPort
	private int port;

	@Test
	public void test() throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		String message = "안녕하세요?";
		String urlEncodedMessage = URLEncoder.encode(message, "UTF-8");

		String url = "http://localhost:" + this.port + "/echo?message=" + urlEncodedMessage;
		String echoed = restTemplate.getForObject(url, String.class);
		assertThat(echoed).isNotEqualTo(message);

		URI uri = UriComponentsBuilder.fromHttpUrl(url).build().toUri();
		echoed = restTemplate.getForObject(uri, String.class);
		assertThat(echoed).isNotEqualTo(message);

		uri = UriComponentsBuilder.fromHttpUrl(url).build(true).toUri();
		echoed = restTemplate.getForObject(uri, String.class);
		assertThat(echoed).isEqualTo(message);
	}

}

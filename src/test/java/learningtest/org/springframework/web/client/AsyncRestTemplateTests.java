package learningtest.org.springframework.web.client;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link AsyncRestTemplate}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class
)
public class AsyncRestTemplateTests {

	@LocalServerPort
	private int port;

	@Test
	public void testGetForEntity() throws UnsupportedEncodingException {
		AsyncRestTemplate restTemplate = new AsyncRestTemplate();
		String message = "안녕하세요?";
		String urlEncodedMessage = URLEncoder.encode(message, "UTF-8");

		String url = "http://localhost:" + this.port + "/echo?message=" + urlEncodedMessage;
		URI uri = UriComponentsBuilder.fromHttpUrl(url).build(true).toUri();
		ListenableFuture<ResponseEntity<String>> future = restTemplate
				.getForEntity(uri, String.class);

		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}

		future.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {

			@Override
			public void onFailure(Throwable ex) {
				System.out.println(ex);
			}

			@Override
			public void onSuccess(ResponseEntity<String> result) {
				System.out.println(result);
			}

		});

		try {
			ResponseEntity<String> responseEntity = future.get();
			assertThat(responseEntity.getBody()).isEqualTo(message);
		}
		catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
		catch (ExecutionException ex) {
			throw new RuntimeException(ex);
		}
	}

}

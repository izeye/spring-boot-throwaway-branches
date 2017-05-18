package learningtest.org.springframework.web.client;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Performance tests for {@link RestTemplate}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class
)
public class RestTemplatePerformanceTests {

	private static final int DEFAULT_TOMCAT_MAX_THREADS = 200;
	private static final int DEFAULT_TIMEOUT = 500;

	private static final long DELAY_IN_MILLIS = 100;

	private final ExecutorService executorService = Executors.newFixedThreadPool(
			DEFAULT_TOMCAT_MAX_THREADS);

	@LocalServerPort
	private int port;

	private RestTemplate pooledRestTemplate;
	private RestTemplate nonPooledRestTemplate;

	@Autowired
	public void createPooledRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		this.pooledRestTemplate = restTemplateBuilder
				.setConnectTimeout(DEFAULT_TIMEOUT)
				.setReadTimeout(DEFAULT_TIMEOUT)
				.build();
	}

	@Autowired
	public void createNonPooledRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		this.nonPooledRestTemplate = restTemplateBuilder
				.setConnectTimeout(DEFAULT_TIMEOUT)
				.setReadTimeout(DEFAULT_TIMEOUT)
				.requestFactory(new SimpleClientHttpRequestFactory())
				.build();
	}

	@Test
	public void testPooledRestTemplate() throws UnsupportedEncodingException {
		test(this.pooledRestTemplate, 1_000);
	}

	@Test
	public void testNonPooledRestTemplate() throws UnsupportedEncodingException {
		test(this.nonPooledRestTemplate, 10_000);
	}

	private void test(RestTemplate restTemplate, int requestCount) {
		String url = "http://localhost:" + this.port
				+ "/performance-tests?delayInMillis={delayInMillis}";

		AtomicLong transactionCount = new AtomicLong(0);
		AtomicLong errorCount = new AtomicLong(0);
		new Timer().schedule(new TimerTask() {

			private long previousTransactionCount = 0;
			private long previousErrorCount;

			@Override
			public void run() {
				long currentTransactionCount = transactionCount.get();
				long currentErrorCount = errorCount.get();

				long diffTransactionCount = currentTransactionCount - this.previousTransactionCount;
				this.previousTransactionCount = currentTransactionCount;

				long diffErrorCount = currentErrorCount - this.previousErrorCount;
				this.previousErrorCount = currentErrorCount;

				System.out.println("TPS: " + diffTransactionCount);
				System.out.println("Errors: " + diffErrorCount + ", error ratio: "
						+ (diffErrorCount * 100d / diffTransactionCount));

				ThreadPoolExecutor executor = (ThreadPoolExecutor) executorService;
				System.out.println("Active threads: " + executor.getActiveCount());
				System.out.println("Queue size: " + executor.getQueue().size());
			}

		}, 0, 1000);

		List<Future<Long>> futures = new ArrayList<>();
		for (int i = 1; i <= requestCount; i++) {
			long startTimeMillis = System.currentTimeMillis();
			Future<Long> future = this.executorService.submit(() -> {
				String response = restTemplate
						.getForObject(url, String.class, DELAY_IN_MILLIS);
				assertThat(response).isEqualTo(String.valueOf(DELAY_IN_MILLIS));
				transactionCount.incrementAndGet();
				return System.currentTimeMillis() - startTimeMillis;
			});
			futures.add(future);

			if (i % 10 == 0) {
				try {
					Thread.sleep(10);
				}
				catch (InterruptedException ex) {
					throw new RuntimeException(ex);
				}
			}
		}

		for (Future<Long> future : futures) {
			try {
				long elapsedTimeMillis = future.get();
//				System.out.println(elapsedTimeMillis);
			}
			catch (InterruptedException ex) {
				throw new RuntimeException(ex);
			}
			catch (ExecutionException ex) {
				errorCount.incrementAndGet();
//				System.out.println(ex.getMessage());
			}
		}
	}

}

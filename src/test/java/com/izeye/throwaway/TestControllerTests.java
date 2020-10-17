package com.izeye.throwaway;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.junit.jupiter.api.Test;
import reactor.netty.http.client.HttpClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link TestController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTests {

	private final WebClient webClient;
	private final int port;

	TestControllerTests(@Autowired WebClient.Builder webClientBuilder, @LocalServerPort int port) {
		HttpClient httpClient = HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 500)
				.doOnConnected((connection) -> connection.addHandlerLast(
						new ReadTimeoutHandler(500, TimeUnit.MILLISECONDS)));
		this.webClient = webClientBuilder.clientConnector(new ReactorClientHttpConnector(httpClient)).build();
		this.port = port;
	}

	@Test
	void firstDelay() {
		String uri = "http://localhost:" + this.port + "/test/first_delay";
		assertThatThrownBy(() -> this.webClient.get().uri(uri).retrieve().bodyToMono(String.class).block())
				.hasCauseExactlyInstanceOf(ReadTimeoutException.class);
	}

	@Test
	void firstDelayWithRetry() {
		String uri = "http://localhost:" + this.port + "/test/first_delay";
		String response = this.webClient.get().uri(uri).retrieve().bodyToMono(String.class).retry().block();
		assertThat(response).isEqualTo("Completed.");
	}

}

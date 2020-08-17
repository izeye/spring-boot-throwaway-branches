package learningtest.org.springframework.web.reactive.function.client;

import java.util.Comparator;
import java.util.List;
import org.springframework.web.reactive.function.client.WebClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.izeye.throwaway.person.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.lanwen.wiremock.ext.WiremockResolver;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link WebClient}.
 *
 * @author Johnny Lim
 */
@ExtendWith(WiremockResolver.class)
class WebClientTests {

	@Test
	void test(@WiremockResolver.Wiremock WireMockServer server) {
		int numOfRequests = 2;

		for (int i = 1; i <= numOfRequests; i++) {
			server.stubFor(get(urlEqualTo("/persons/" + i)).willReturn(aResponse()
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(String.format("{ \"id\": %d }", i))));
		}

		WebClient webClient = WebClient.create(server.baseUrl());
		for (int i = 0; i < 1000; i++) {
			System.out.println("#" + i);
			List<Person> persons = Flux.just(1L, 2L).parallel().runOn(Schedulers.boundedElastic())
					.flatMap((id) -> getPerson(webClient, id)).ordered(Comparator.comparing(Person::getId)).collectList().block();
			assertThat(persons).hasSize(2);
		}
	}

	private Mono<Person> getPerson(WebClient webClient, Long id) {
		return webClient.get()
				.uri("/persons/{id}", id)
				.retrieve()
				.bodyToMono(Person.class);
	}

}

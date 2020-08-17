package com.izeye.throwaway.person.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.domain.PersonWithItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.lanwen.wiremock.ext.WiremockResolver;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RemotePersonService}.
 *
 * @author Johnny Lim
 */
@ExtendWith(WiremockResolver.class)
class RemotePersonServiceTests {

	@Test
	void getPersons(@WiremockResolver.Wiremock WireMockServer server) {
		RemotePersonService personService = new DefaultRemotePersonService(server.baseUrl());

		int numOfRequests = 5;
		int responseTime = 1000;

		for (int i = 1; i <= numOfRequests; i++) {
			server.stubFor(get(urlEqualTo("/persons/" + i)).willReturn(aResponse()
					.withFixedDelay(responseTime)
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(String.format("{ \"id\": %d }", i))));
		}

		List<Long> ids = LongStream.rangeClosed(1, numOfRequests)
				.boxed()
				.collect(Collectors.toList());

		long startTimeMillis = System.currentTimeMillis();
		List<Person> persons = personService.getPersons(ids).collectList().block();
		long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
		assertThat(persons).hasSize(numOfRequests);
		assertThat(elapsedTimeMillis).isLessThan(responseTime * 3);
	}

	@Test
	void getPersonAndOtherPerson(@WiremockResolver.Wiremock WireMockServer server) {
		RemotePersonService personService = new DefaultRemotePersonService(server.baseUrl());

		int numOfRequests = 1;
		int responseTime = 1000;

		for (int i = 1; i <= numOfRequests; i++) {
			server.stubFor(get(urlEqualTo("/persons/" + i)).willReturn(aResponse()
					.withFixedDelay(responseTime)
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(String.format("{ \"id\": %d }", i))));
			server.stubFor(get(urlEqualTo("/otherPersons/" + i)).willReturn(aResponse()
					.withFixedDelay(responseTime)
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(String.format("{ \"id\": %d }", i))));
		}

		long startTimeMillis = System.currentTimeMillis();
		List<Person> persons = personService.getPersonAndOtherPerson(1L).collectList().block();
		long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
		assertThat(persons).hasSize(2);
		assertThat(elapsedTimeMillis).isLessThan(responseTime * 2);
	}

	@Test
	void getPersonWithItem(@WiremockResolver.Wiremock WireMockServer server) {
		RemotePersonService personService = new DefaultRemotePersonService(server.baseUrl());

		int numOfRequests = 1;
		int responseTime = 1000;

		for (int i = 1; i <= numOfRequests; i++) {
			server.stubFor(get(urlEqualTo("/persons/" + i)).willReturn(aResponse()
					.withFixedDelay(responseTime)
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(String.format("{ \"id\": %d }", i))));
			server.stubFor(get(urlEqualTo("/items/" + i)).willReturn(aResponse()
					.withFixedDelay(responseTime)
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(String.format("{ \"id\": %d }", i))));
		}

		long startTimeMillis = System.currentTimeMillis();
		PersonWithItem personWithItem = personService.getPersonWithItem(1L, 1L).block();
		long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
		assertThat(personWithItem).isNotNull();
		assertThat(elapsedTimeMillis).isLessThan(responseTime * 2);
	}

}

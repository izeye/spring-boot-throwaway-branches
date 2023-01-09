package com.izeye.throwaway.web;

import com.izeye.throwaway.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonController} with {@link WebClient}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerWebClientTests {

    private final WebClient webClient;

    private final int port;

    PersonControllerWebClientTests(WebClient.Builder webClientBuilder, @LocalServerPort int port) {
        this.webClient = webClientBuilder.build();
        this.port = port;
    }

    @Test
    void add() {
        long id = 1L;
        String firstName = "Johnny";
        String lastName = "Lim";
        Person person = new Person(id, firstName, lastName);
        Person posted = this.webClient.post().uri("http://localhost:" + this.port + "/persons").body(BodyInserters.fromValue(person)).retrieve().bodyToMono(Person.class).block();
        assertThat(posted.getId()).isEqualTo(id);
        assertThat(posted.getFirstName()).isEqualTo(firstName);
        assertThat(posted.getLastName()).isEqualTo(lastName);
    }

}

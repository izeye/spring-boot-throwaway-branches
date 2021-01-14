package com.izeye.throwaway.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Tests for {@link PersonController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTests {

    @LocalServerPort
    private int port;

    // NOTE: This doesn't work with Spring Boot 2.0.x.
    @Test
    void restTemplateWithStringSupportsUtf8() {
        String response =  new RestTemplate().getForObject("http://localhost:" + this.port + "/persons/1", String.class);
        assertThat(response).contains("한글 이름");
    }

}

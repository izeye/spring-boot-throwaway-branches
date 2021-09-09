package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link RestTemplate}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateTests {

    @LocalServerPort
    private int port;

    @Test
    void notFound(@Autowired RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        assertThatThrownBy(() -> restTemplate.exchange("http://localhost:" + port + "/nonExistent", HttpMethod.GET, null, String.class))
                .isInstanceOf(HttpClientErrorException.NotFound.class);
    }

    @Test
    void badRequest(@Autowired RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        assertThatThrownBy(() -> restTemplate.exchange("http://localhost:" + port + "/test/request-parameter", HttpMethod.GET, null, String.class))
                .isInstanceOf(HttpClientErrorException.BadRequest.class);
    }

}

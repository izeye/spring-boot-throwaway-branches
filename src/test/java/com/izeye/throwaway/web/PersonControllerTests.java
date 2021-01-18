package com.izeye.throwaway.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

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
    void restTemplateGetForObjectWithStringSupportsUtf8() {
        String response =  new RestTemplate().getForObject("http://localhost:" + this.port + "/persons/1", String.class);
        assertThat(response).contains("한글 이름");
    }

    @Test
    void contentType() {
        ResponseEntity<String> response =  new RestTemplate().exchange("http://localhost:" + this.port + "/persons/1", HttpMethod.GET, null, String.class);
        assertThat(response.getBody()).contains("한글 이름");
        assertThat(response.getHeaders().get("Content-Type")).containsExactly("application/json");
    }

    @Test
    void contentTypeWithProduces() {
        ResponseEntity<String> response =  new RestTemplate().exchange("http://localhost:" + this.port + "/persons/1/forceContentTypeUtf8Charset", HttpMethod.GET, null, String.class);
        assertThat(response.getBody()).contains("한글 이름");
        assertThat(response.getHeaders().get("Content-Type")).containsExactly("application/json;charset=utf-8");
    }

}

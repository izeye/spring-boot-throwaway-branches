package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link TestController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void rejectHeaderValueCanBeDisabled() {
        String disallowedHeaderValue = "č";

        // Note that Tomcat converts header value bytes to characters using ISO-8859-1.
        String expectedResponseBody = new String(disallowedHeaderValue.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header", disallowedHeaderValue);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = this.restTemplate.exchange("/test/reject-header-value", HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }

}

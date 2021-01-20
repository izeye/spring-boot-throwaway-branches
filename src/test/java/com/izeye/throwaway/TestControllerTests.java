package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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

    @LocalServerPort
    private int port;

    // Note that RestTemplate with Apache HttpClient will convert header values to ASCII bytes, so it won't be affected
    // by default StrictHttpFirewall.
    @Test
    void apacheHttpClientEnforcesAsciiForHeaderValues() {
        String disallowedHeaderValue = "č";

        byte[] bytesWithApacheHttpClient = disallowedHeaderValue.getBytes(StandardCharsets.US_ASCII);

        // Note that Tomcat converts header value bytes to characters using ISO-8859-1.
        String expectedResponseBody = new String(bytesWithApacheHttpClient, StandardCharsets.ISO_8859_1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header", disallowedHeaderValue);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = this.restTemplate.exchange("/test/reject-header-value", HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }

    @Test
    void rejectHeaderValueCanBeDisabled() {
        // Note that RestTemplate with HttpURLConnection will convert header values to UTF-8, so it will be affected by
        // default StrictHttpFirewall.
        RestTemplate restTemplate = new RestTemplate();

        String disallowedHeaderValue = "č";

        byte[] bytesWithHttpURLConnection = disallowedHeaderValue.getBytes(StandardCharsets.UTF_8);

        // Note that Tomcat converts header value bytes to characters using ISO-8859-1.
        String expectedResponseBody = new String(bytesWithHttpURLConnection, StandardCharsets.ISO_8859_1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header", disallowedHeaderValue);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + this.port + "/test/reject-header-value", HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }

}

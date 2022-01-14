package com.izeye.throwaway.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.TimeUnit;

/**
 * Tests for {@link TestRestController}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestRestControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONNECTION, "close");
            HttpEntity<Void> request = new HttpEntity<>(headers);
            ResponseEntity<String> response = this.restTemplate.exchange("/test/remote-port", HttpMethod.GET, request, String.class);
            System.out.println("Response: " + response.getBody());
            TimeUnit.SECONDS.sleep(1);
        }
    }

}

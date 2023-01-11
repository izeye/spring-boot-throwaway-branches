package com.izeye.throwaway.learningtest.org.springframework.web.util;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UriComponentsBuilder}.
 *
 * @author Johnny Lim
 */
class UriComponentsBuilderTests {

    @Test
    void test() {
        String uriString = UriComponentsBuilder.fromHttpUrl("https://www.izeye.com")
                .path("/")
                .queryParam("name", "값")
                .toUriString();
        assertThat(uriString).isEqualTo("https://www.izeye.com/?name=%EA%B0%92");
    }

}

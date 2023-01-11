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
                .queryParam("name1", "값1")
                .queryParam("name2", "값2")
                .toUriString();
        assertThat(uriString).isEqualTo("https://www.izeye.com/?name1=%EA%B0%921&name2=%EA%B0%922");
    }

}

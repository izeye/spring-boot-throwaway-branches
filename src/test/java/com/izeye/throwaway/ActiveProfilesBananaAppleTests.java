package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Tests for {@link ActiveProfiles} with {@literal banana} and {@literal apple} Spring profiles.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@ActiveProfiles({ "banana", "apple" })
class ActiveProfilesBananaAppleTests {

    @Value("${favorite-fruit}")
    private String favoriteFruit;

    @Test
    void favoriteFruit() {
        assertThat(this.favoriteFruit).isEqualTo("apple");
    }

}

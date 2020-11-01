package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Tests for {@link ActiveProfiles} with {@literal apple} and {@literal banana} Spring profiles.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@ActiveProfiles({ "apple", "banana" })
class ActiveProfilesAppleBananaTests {

    @Value("${favorite-fruit}")
    private String favoriteFruit;

    @Test
    void favoriteFruit() {
        assertThat(this.favoriteFruit).isEqualTo("banana");
    }

}

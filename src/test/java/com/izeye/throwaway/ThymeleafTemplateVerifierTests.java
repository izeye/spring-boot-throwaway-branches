package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.SpelEvaluationException;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link ThymeleafTemplateVerifier}.
 *
 * @author Johnny Lim
 */
class ThymeleafTemplateVerifierTests {

    private final ThymeleafTemplateVerifier verifier = new DefaultThymeleafTemplateVerifier();

    @Test
    void verify() {
        Map<String, Object> model = Collections.emptyMap();

        assertThatNoException().isThrownBy(() -> verifier.verify("test", model));
    }

    @Test
    void verifyWithMissingField() {
        Person person = new Person();
        person.setFirstName("Johnny");
        person.setLastName("Lim");
        person.setAge(20);

        Map<String, Object> model = Collections.singletonMap("person", person);

        assertThatThrownBy(() -> verifier.verify("test_missing_field", model))
                .hasCauseInstanceOf(SpelEvaluationException.class);
    }

}

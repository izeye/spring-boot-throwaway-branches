package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.spel.SpelEvaluationException;
import org.thymeleaf.TemplateEngine;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link ThymeleafTemplateTestRenderer}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class ThymeleafTemplateTestRendererTests {

    @Autowired
    private ThymeleafTemplateTestRenderer renderer;

    @Test
    void render() {
        Map<String, Object> model = Collections.emptyMap();

        assertThatNoException().isThrownBy(() -> renderer.render("test", model));
    }

    @Test
    void renderWithMissingField() {
        Person person = new Person();
        person.setFirstName("Johnny");
        person.setLastName("Lim");
        person.setAge(20);

        Map<String, Object> model = Collections.singletonMap("person", person);

        assertThatThrownBy(() -> renderer.render("test_missing_field", model))
                .hasCauseInstanceOf(SpelEvaluationException.class);
    }

    @Test
    void renderWithReferenceBean() {
        Map<String, Object> model = Collections.emptyMap();

        assertThatNoException().isThrownBy(() -> renderer.render("test_reference_bean", model));
    }

    @TestConfiguration
    static class ThymeleafTemplateTestRendererConfiguration {

        @Bean
        ThymeleafTemplateTestRenderer thymeleafTemplateTestRenderer(TemplateEngine engine) {
            return new DefaultThymeleafTemplateTestRenderer(engine);
        }

    }

}

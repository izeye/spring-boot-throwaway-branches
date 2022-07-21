package com.izeye.throwaway;

import com.izeye.throwaway.config.AppConfig;
import com.izeye.throwaway.service.DefaultPersonService;
import com.izeye.throwaway.service.PersonServiceConsumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SpringExtension}.
 *
 * @author Johnny Lim
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class, DefaultPersonService.class })
class SpringExtensionTests {

    @Autowired
    private PersonServiceConsumer personServiceConsumer;

    @Test
    void test() {
        assertThat(this.personServiceConsumer).isNotNull();
    }

}

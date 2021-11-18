package com.izeye.external;

import com.izeye.throwaway.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests for an external service.
 *
 * @author Johnny Lim
 */
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ExternalServiceTests {

    @Test
    void test() {
    }

}

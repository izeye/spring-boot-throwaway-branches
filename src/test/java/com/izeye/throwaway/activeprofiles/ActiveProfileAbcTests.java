package com.izeye.throwaway.activeprofiles;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({ "a", "b", "c" })
public class ActiveProfileAbcTests {

    @Test
    void test() {
    }

}

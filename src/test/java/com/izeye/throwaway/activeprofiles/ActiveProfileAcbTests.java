package com.izeye.throwaway.activeprofiles;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({ "a", "c", "b" })
public class ActiveProfileAcbTests {

    @Test
    void test() {
    }

}


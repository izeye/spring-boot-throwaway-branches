package com.izeye.throwaway.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link ScheduledInConfig}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScheduledInConfigTests {

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(10000);
    }

}

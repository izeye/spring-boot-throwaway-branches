package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by izeye on 15. 12. 9..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTests {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		log.info("Hello, world!");
	}
	
}

package learningtest.org.slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.izeye.throwaway.Application;

/**
 * Tests for {@link Logger}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		classes = Application.class
)
public class LoggerTests {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		log.info("Hello, world!");
	}
	
}

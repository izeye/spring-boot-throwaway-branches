package learningtest.org.springframework.test.context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.izeye.throwaway.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for {@link ActiveProfiles}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		classes = Application.class
)
@ActiveProfiles({"test1", "test2"})
public class ActiveProfilesTests {
	
	@Autowired
	private Environment environment;
	
	@Test
	public void testGetActiveProfiles() {
		assertThat(environment.getActiveProfiles(), is(new String[] { "test1", "test2" }));
	}
	
}

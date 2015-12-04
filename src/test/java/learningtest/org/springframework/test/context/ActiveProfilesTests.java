package learningtest.org.springframework.test.context;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 12. 4..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles({"test1", "test2"})
public class ActiveProfilesTests {
	
	@Autowired
	Environment environment;
	
	@Test
	public void testGetActiveProfiles() {
		assertThat(environment.getActiveProfiles(), is(new String[] { "test1", "test2" }));
	}
	
}

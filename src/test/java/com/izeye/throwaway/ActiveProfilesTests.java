package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 12. 4..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"test1", "test2"})
public class ActiveProfilesTests {
	
	@Autowired
	Environment environment;
	
	@Test
	public void testGetActiveProfiles() {
		assertThat(environment.getActiveProfiles(), is(new String[] { "test1", "test2" }));
	}
	
}

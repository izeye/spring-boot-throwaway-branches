package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ActiveProfiles}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
@ActiveProfiles({ "test1", "test2" })
class ActiveProfilesTests {
	
	@Autowired
	private Environment environment;
	
	@Test
	void getActiveProfiles() {
		assertThat(environment.getActiveProfiles()).containsOnly("test1", "test2");
	}
	
}

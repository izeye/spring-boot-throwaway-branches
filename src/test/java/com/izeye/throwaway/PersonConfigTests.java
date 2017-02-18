package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonConfig}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PersonConfigTests {

	// 'spring.config.location' doesn't work in 'application.properties'.
	static {
		System.setProperty("spring.config.location", "classpath:/some/some.properties");
	}

	@Autowired
	private Person person;

	@Autowired
	private Person somePerson;

	@Test
	public void testPerson() {
		assertThat(this.person.getFirstName()).isEqualTo("Johnny");
		assertThat(this.person.getLastName()).isEqualTo("Lim");
	}

	// This doesn't work with './gradlew clean test'. Why?
	@Ignore
	@Test
	public void testSomePerson() {
		assertThat(this.somePerson.getFirstName()).isEqualTo("John");
		assertThat(this.somePerson.getLastName()).isEqualTo("Kim");
	}

}

package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonService}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class PersonServiceTests {

	private final PersonService personService;

	PersonServiceTests(@Autowired PersonService personService) {
		this.personService = personService;
	}

	@Test
	void getWorksWithCache() {
		assertThat(this.personService.get(1L)).isSameAs(this.personService.get(1L));
	}

}
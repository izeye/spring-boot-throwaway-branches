package com.izeye.throwaway;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Person}.
 *
 * @author Johnny Lim
 */
class PersonTests {
	
	@Test
	void test() {
		long personId = 1L;
		
		Person person = new Person();
		person.setId(personId);
		
		assertThat(person.getId()).isEqualTo(personId);
	}
	
}

package com.izeye.throwaway.domain;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 9. 19..
 */
class PersonTests {
	
	@Test
	void test() {
		long personId = 1L;
		
		Person person = new Person();
		person.setId(personId);
		System.out.println(person);
		
		assertThat(person.getId(), is(personId));
	}
	
}

package com.izeye.throwaway.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 9. 19..
 */
public class PersonTests {
	
	@Test
	public void test() {
		long personId = 1L;
		
		Person person = new Person();
		person.setId(personId);
		
		assertThat(person.getId(), is(personId));
	}
	
}

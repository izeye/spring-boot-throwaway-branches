package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 15. 9. 19..
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

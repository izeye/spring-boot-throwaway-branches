package com.izeye.throwaway.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.izeye.throwaway.domain.Person;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonRepository}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class PersonRepositoryTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void test() {
		Person person = new Person(1L, "Johnny", "Lim");
		assertThat(this.personRepository.save(person)).isSameAs(person);
		assertThat(this.personRepository.findById(person.getId())).contains(person);
	}

}

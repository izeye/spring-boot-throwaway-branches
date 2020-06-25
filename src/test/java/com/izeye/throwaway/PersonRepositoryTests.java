package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PersonRepository}.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PersonRepositoryTests {
	
	@Autowired
	PersonRepository personRepository;
	
	@Test
	@Transactional
	void test() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		personRepository.save(person);

		List<Person> persons = personRepository.findAll();
		assertThat(persons.size()).isEqualTo(4);
		assertThat(persons).contains(person);
	}
	
}

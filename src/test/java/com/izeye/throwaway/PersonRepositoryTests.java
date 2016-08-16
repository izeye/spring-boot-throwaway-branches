package com.izeye.throwaway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 10. 1..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PersonRepositoryTests {
	
	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void test() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		personRepository.save(person);

		List<Person> persons = personRepository.findAll();
		assertThat(persons.size(), is(1));
		assertThat(persons.get(0), is(person));

		// To confirm that the only `person` table will be updated
		person.setAge(100);
		personRepository.save(person);

		persons = personRepository.findAll();
		assertThat(persons.size(), is(1));
		assertThat(persons.get(0), is(person));

		// To confirm that the only `person_name` table will be updated
		person.setFirstName("John");
		personRepository.save(person);

		persons = personRepository.findAll();
		assertThat(persons.size(), is(1));
		assertThat(persons.get(0), is(person));
	}
	
}

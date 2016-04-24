package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

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
	
	@Autowired
	SomeGroupRepository someGroupRepository;
	
	@Test
	@Transactional
	public void test() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(36);
		personRepository.save(person);

		List<Person> persons = personRepository.findAll();
		assertThat(persons.size(), is(1));
		assertThat(persons.get(0), is(person));
	}
	
	@Test
	@Transactional
	public void testSomeMethodUsingQueryAnnotation() {
		SomeGroup group = new SomeGroup();
		group.setName("CTB");
		someGroupRepository.save(group);

		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(36);
		person.setGroup(group);
		personRepository.save(person);
		
		List<Person> persons = personRepository.someMethodUsingQueryAnnotation(group);
		System.out.println(persons);
	}
	
}

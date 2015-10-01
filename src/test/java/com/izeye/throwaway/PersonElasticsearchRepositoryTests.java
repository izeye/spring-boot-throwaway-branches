package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;

/**
 * Created by izeye on 15. 10. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PersonElasticsearchRepositoryTests {
	
	@Autowired
	PersonElaticsearchRepository personElaticsearchRepository;
	
	@Test
	public void test() {
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		
		personElaticsearchRepository.save(person);

		Iterable<Person> persons = personElaticsearchRepository.findAll();
		Iterator<Person> personIterator = persons.iterator();
		assertThat(personIterator.next(), is(person));
		assertFalse(personIterator.hasNext());
	}
	
}

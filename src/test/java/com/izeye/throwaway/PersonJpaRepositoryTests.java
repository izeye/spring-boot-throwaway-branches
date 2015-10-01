package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 10. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PersonJpaRepositoryTests {
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	@Test
	@Transactional
	public void test() {
		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		personJpaRepository.save(person);

		List<Person> persons = personJpaRepository.findAll();
		assertThat(persons.size(), is(1));
		assertThat(persons.get(0), is(person));
	}
	
}

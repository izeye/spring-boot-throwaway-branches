package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by izeye on 16. 3. 27..
 */
@Service
public class DefaultPersonService implements PersonService {

	@Override
	public List<Person> findAll() {
		return Collections.singletonList(createDummyPerson());
	}

	@Override
	public Person findByFirstName(String firstName) {
		Person person = createDummyPerson();
		person.setFirstName(firstName);
		return person;
	}

	private Person createDummyPerson() {
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		person.setCreatedTime(new Date());
		return person;
	}
	
}

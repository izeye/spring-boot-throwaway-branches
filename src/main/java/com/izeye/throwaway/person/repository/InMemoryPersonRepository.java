package com.izeye.throwaway.person.repository;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.domain.TestDomainFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by izeye on 16. 7. 15..
 */
@Repository
public class InMemoryPersonRepository implements PersonRepository {
	
	private static final int COUNT = 10;
	
	private static final List<Person> PERSONS;
	private static final Map<Long, Person> PERSON_BY_ID;
	private static final Map<String, Person> PERSON_BY_FIRST_NAME;
	
	static {
		List<Person> persons = new ArrayList<>();
		Map<Long, Person> personById = new HashMap<>();
		Map<String, Person> personByFirstName = new HashMap<>();
		for (int i = 0; i < COUNT; i++) {
			Person person = TestDomainFactory.createPerson();
			persons.add(person);
			personById.put(person.getId(), person);
			personByFirstName.put(person.getFirstName(), person);
		}
		PERSONS = Collections.unmodifiableList(persons);
		PERSON_BY_ID = Collections.unmodifiableMap(personById);
		PERSON_BY_FIRST_NAME = Collections.unmodifiableMap(personByFirstName);
	}
	
	@Override
	public List<Person> findAll() {
		return PERSONS;
	}

	@Override
	public Person findById(Long id) {
		return PERSON_BY_ID.get(id);
	}

	@Override
	public Person findByFirstName(String firstName) {
		return PERSON_BY_FIRST_NAME.get(firstName);
	}
	
}

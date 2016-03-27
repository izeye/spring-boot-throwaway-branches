package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.domain.TestDomainFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by izeye on 16. 3. 27..
 */
@Service
public class DefaultPersonService implements PersonService {

	@Override
	public List<Person> findAll() {
		return Collections.singletonList(TestDomainFactory.createPerson());
	}

	@Override
	public Person findByFirstName(String firstName) {
		Person person = TestDomainFactory.createPerson();
		person.setFirstName(firstName);
		return person;
	}
	
}

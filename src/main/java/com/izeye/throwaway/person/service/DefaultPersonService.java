package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by izeye on 16. 3. 27..
 */
@Service
public class DefaultPersonService implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}

	@Override
	public Person findById(Long id) {
		return this.personRepository.findById(id);
	}

	@Override
	public Person findByFirstName(String firstName) {
		return this.personRepository.findByFirstName(firstName);
	}

}

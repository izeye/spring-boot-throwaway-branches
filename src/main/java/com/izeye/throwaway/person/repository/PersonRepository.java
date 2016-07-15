package com.izeye.throwaway.person.repository;

import com.izeye.throwaway.person.domain.Person;

import java.util.List;

/**
 * Created by izeye on 16. 7. 15..
 */
public interface PersonRepository {

	List<Person> findAll();

	Person findById(Long id);

	Person findByFirstName(String firstName);
	
}

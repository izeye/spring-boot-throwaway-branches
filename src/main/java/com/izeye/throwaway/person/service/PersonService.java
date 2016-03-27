package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;

import java.util.List;

/**
 * Created by izeye on 16. 3. 27..
 */
public interface PersonService {

	List<Person> findAll();
	
	Person findByFirstName(String firstName);
	
}

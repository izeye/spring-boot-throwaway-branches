package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by izeye on 16. 7. 15..
 */
@Service
public class PersonConverter implements Converter<String, Person> {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person convert(String source) {
		return personRepository.findById(Long.valueOf(source));
	}
	
}

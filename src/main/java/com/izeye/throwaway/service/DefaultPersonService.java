package com.izeye.throwaway.service;

import org.springframework.stereotype.Service;

import com.izeye.throwaway.domain.Person;

/**
 * Default {@link PersonService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultPersonService implements PersonService {

	@Override
	public Person get(Long id) {
		return new Person(id, "Johnny", "Lim");
	}

}

package com.izeye.throwaway;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Default {@link PersonService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultPersonService implements PersonService {

	@Cacheable("persons")
	@Override
	public Person get(Long id) {
		return new Person(id, "Johnny", "Lim");
	}

}

package com.izeye.throwaway.service;

import com.izeye.throwaway.domain.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by izeye on 16. 4. 2..
 */
@Service
public class DefaultPersonService implements PersonService {

	@Override
	public Person getPerson() {
		return new Person();
	}

	@Override
	public Person getPersonWithInterfaceCacheable() {
		return new Person();
	}

	@Cacheable(cacheNames = "classLevelPersonCache")
	@Override
	public Person getPersonWithClassCacheable() {
		return new Person();
	}
	
}

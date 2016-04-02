package com.izeye.throwaway.service;

import com.izeye.throwaway.domain.Person;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by izeye on 16. 4. 2..
 */
public interface PersonService {
	
	Person getPerson();
	
	@Cacheable(cacheNames = "interfaceLevelPersonCache")
	Person getPersonWithInterfaceCacheable();
	
	Person getPersonWithClassCacheable();
	
}

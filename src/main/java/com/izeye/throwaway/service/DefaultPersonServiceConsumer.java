package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by izeye on 16. 4. 4..
 */
public class DefaultPersonServiceConsumer implements PersonServiceConsumer {
	
	@Autowired
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}
	
}

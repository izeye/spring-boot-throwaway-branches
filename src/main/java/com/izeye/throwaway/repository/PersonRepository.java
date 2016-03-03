package com.izeye.throwaway.repository;

import com.izeye.throwaway.domain.Person;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
public interface PersonRepository {

	List<Person> findAll();

}

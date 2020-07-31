package com.izeye.throwaway.person.repository;

import com.izeye.throwaway.person.domain.Person;
import reactor.core.publisher.Flux;

/**
 * Repository for {@link Person}.
 *
 * @author Johnny Lim
 */
public interface PersonRepository {

    Flux<Person> findAll();

}

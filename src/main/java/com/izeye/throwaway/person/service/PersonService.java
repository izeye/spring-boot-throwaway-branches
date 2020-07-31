package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;
import reactor.core.publisher.Flux;

/**
 * Service for {@link Person}.
 *
 * @author Johnny Lim
 */
public interface PersonService {

    Flux<Person> getPersons();

}

package com.izeye.throwaway.person.repository;

import com.izeye.throwaway.person.domain.Person;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Default {@link PersonRepository}.
 *
 * @author Johnny Lim
 */
@Repository
public class DefaultPersonRepository implements PersonRepository {

    @Override
    public Flux<Person> findAll() {
        return Flux.just(new Person("Johnny", "Lim"));
    }

}

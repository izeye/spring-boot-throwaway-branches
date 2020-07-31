package com.izeye.throwaway.person.service;

import com.izeye.throwaway.person.domain.Person;
import com.izeye.throwaway.person.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Default {@link PersonService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultPersonService implements PersonService {

    private final PersonRepository personRepository;

    public DefaultPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Flux<Person> getPersons() {
        return this.personRepository.findAll().timeout(Duration.ofSeconds(5)).retry(5);
    }

}

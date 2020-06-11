package com.izeye.throwaway.repository;

import org.springframework.data.repository.CrudRepository;
import com.izeye.throwaway.domain.Person;

/**
 * {@link CrudRepository} for {@link Person}.
 *
 * @author Johnny Lim
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}

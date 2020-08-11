package com.izeye.throwaway;

import org.springframework.data.repository.CrudRepository;

/**
 * {@link CrudRepository} for {@link Person}.
 *
 * @author Johnny Lim
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}

package com.izeye.throwaway.service;

import com.izeye.throwaway.domain.Person;

/**
 * Service for {@link Person}.
 *
 * @author Johnny Lim
 */
public interface PersonService {

	Person get(Long id);

}

package com.izeye.throwaway;

import com.izeye.common.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 15. 10. 1..
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}

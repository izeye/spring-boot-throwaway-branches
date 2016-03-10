package com.izeye.throwaway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by izeye on 15. 10. 1..
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("SELECT person FROM Person person WHERE person.group = :group")
	List<Person> someMethodUsingQueryAnnotation(@Param("group") SomeGroup group);
	
}

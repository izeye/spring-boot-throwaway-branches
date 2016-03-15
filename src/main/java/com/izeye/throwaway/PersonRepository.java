package com.izeye.throwaway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by izeye on 15. 10. 1..
 */
@RepositoryRestResource(excerptProjection = GroupInlinedPerson.class)
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByFavoriteFruit(@Param("favorite_fruit") Fruit favoriteFruit);
	
}

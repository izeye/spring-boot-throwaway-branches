package com.izeye.throwaway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by izeye on 16. 3. 10..
 */
public interface SomeGroupRepository extends JpaRepository<SomeGroup, Long> {

	@Query("SELECT g.id as id, g.name as name FROM SomeGroup g")
	List<AggregatedGroup> aggregate();
	
}

package com.izeye.throwaway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by izeye on 16. 3. 10..
 */
public interface AggregatedGroupRepository extends JpaRepository<AggregatedGroup, Long> {

	@Query("SELECT new AggregatedGroup(id, name) FROM SomeGroup")
	List<AggregatedGroup> aggregate();
	
}

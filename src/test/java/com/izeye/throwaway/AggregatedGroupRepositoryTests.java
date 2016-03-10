package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by izeye on 16. 3. 10..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AggregatedGroupRepositoryTests {
	
	@Autowired
	AggregatedGroupRepository aggregatedGroupRepository;

	@Autowired
	SomeGroupRepository someGroupRepository;

	@Test
	public void testCreateAggregatedGroups() {
		SomeGroup group = new SomeGroup();
		group.setName("CTB");
		someGroupRepository.save(group);

		List<AggregatedGroup> aggregatedGroups = aggregatedGroupRepository.aggregate();
		System.out.println(aggregatedGroups);
	}
	
}

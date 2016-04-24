package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by izeye on 16. 4. 24..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SomeGroupRepositoryTests {

	@Autowired
	SomeGroupRepository someGroupRepository;

	@Test
	public void testAggregate() {
		SomeGroup group = new SomeGroup();
		group.setName("CTB");
		someGroupRepository.save(group);

		List<AggregatedGroup> aggregatedGroups = someGroupRepository.aggregate();
		System.out.println(aggregatedGroups);
	}
	
}

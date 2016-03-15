package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * Created by izeye on 16. 3. 15..
 */
@Configuration
public class TestSetup {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonGroupRepository groupRepository;
	
	@Autowired
	ActivityRepository activityRepository;

	@PostConstruct
	public void setup() {
		PersonGroup group = new PersonGroup();
		group.setName("CTB");
		groupRepository.save(group);
		
		Activity activity = new Activity();
		activity.setName("baseball");
		activityRepository.save(activity);

		Person person = new Person();
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		person.setGroup(group);
		person.setActivities(Collections.singletonList(activity));
		personRepository.save(person);
	}
	
}

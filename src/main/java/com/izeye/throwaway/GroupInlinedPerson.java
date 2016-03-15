package com.izeye.throwaway;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by izeye on 16. 3. 15..
 */
@Projection(name = "groupInlined", types = { Person.class })
public interface GroupInlinedPerson {
	
	Long getId();
	
	String getFirstName();
	
	String getLastName();
	
	int getAge();
	
	Fruit getFavoriteFruit();
	
	PersonGroup getGroup();
	
//	List<Activity> getActivities();
	
}

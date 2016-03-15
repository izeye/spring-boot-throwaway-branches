package com.izeye.throwaway;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by izeye on 15. 9. 19..
 */
@Entity
@Data
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private int age;
	
	private Fruit favoriteFruit;
	
	@ManyToOne
	private PersonGroup group;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Activity> activities;
	
}

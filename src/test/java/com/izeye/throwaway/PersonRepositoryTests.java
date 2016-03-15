package com.izeye.throwaway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by izeye on 15. 10. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PersonRepositoryTests {
	
	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void test() {
		List<Person> persons = personRepository.findAll();
		System.out.println(persons);
	}
	
}

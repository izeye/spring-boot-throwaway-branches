package com.izeye.throwaway.repository;

import com.izeye.throwaway.Application;
import com.izeye.throwaway.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by izeye on 16. 3. 4..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PersonMapperTests {
	
	@Autowired
	PersonMapper personMapper;
	
	@Test
	public void testFindAll() {
		List<Person> persons = personMapper.findAll();
		System.out.println(persons);
	}
	
}

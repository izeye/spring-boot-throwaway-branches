package com.izeye.throwaway.animal.repository;

import com.izeye.throwaway.Application;
import com.izeye.throwaway.animal.domain.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by izeye on 16. 3. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AnimalRepositoryTests {

	@Autowired
	AnimalRepository animalRepository;

	@Test
	public void testFindAll() {
		List<Animal> animals = animalRepository.findAll();
		System.out.println(animals);
	}
	
}

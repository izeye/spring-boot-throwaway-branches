package com.izeye.throwaway.animal.repository;

import com.izeye.throwaway.animal.domain.Animal;

import java.util.List;

/**
 * Created by izeye on 16. 3. 6..
 */
public interface AnimalMapper {

	List<Animal> findAll();
	
}

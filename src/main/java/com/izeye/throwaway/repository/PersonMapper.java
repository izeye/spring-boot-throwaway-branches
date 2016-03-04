package com.izeye.throwaway.repository;

import com.izeye.throwaway.domain.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by izeye on 16. 3. 4..
 */
public interface PersonMapper {
	
	@Select("SELECT * FROM person")
	List<Person> findAll();
	
}

package com.izeye.throwaway.animal.repository;

import com.izeye.throwaway.animal.domain.Animal;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by izeye on 16. 3. 6..
 */
@Repository
public class MyBatisAnimalRepository implements AnimalRepository {

	@Autowired
	// FIXME: See https://github.com/mybatis/spring/issues/58
	@Lazy
	private SqlSession sqlSession;

	@Override
	public List<Animal> findAll() {
		AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);
		return mapper.findAll();
	}
	
}

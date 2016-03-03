package com.izeye.throwaway.repository;

import com.izeye.throwaway.domain.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
@Repository
public class MyBatisPersonRepository implements PersonRepository {

	@Autowired
	// FIXME: See https://github.com/mybatis/spring/issues/58
	@Lazy
	private SqlSession sqlSession;

	@Override
	public List<Person> findAll() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAll();
	}

}

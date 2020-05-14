package com.izeye.throwaway.repository;

import org.springframework.stereotype.Repository;

/**
 * Default {@link TestRepository}.
 *
 * @author Johnny Lim
 */
@Repository
public class DefaultTestRepository implements TestRepository {

	@Override
	public String get(String id) {
		throw new RuntimeException("Failed to get: " + id);
	}

}

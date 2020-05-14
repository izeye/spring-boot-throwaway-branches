package com.izeye.throwaway.repository;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * Default {@link TestRepository}.
 *
 * @author Johnny Lim
 */
@Repository
@Slf4j
public class DefaultTestRepository implements TestRepository {

	@PostConstruct
	void initialize() {
		log.info("@PostConstruct in DefaultTestRepository");
	}

	@Override
	public String get(String id) {
		throw new RuntimeException("Failed to get: " + id);
	}

}

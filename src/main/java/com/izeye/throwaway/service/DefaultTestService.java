package com.izeye.throwaway.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.izeye.throwaway.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Default {@link TestService}.
 *
 * @author Johnny Lim
 */
@Service
@Slf4j
public class DefaultTestService implements TestService {

	private final TestRepository testRepository;

	public DefaultTestService(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	public String get(String id) {
		return this.testRepository.get(id);
	}

	@PostConstruct
	void warmUp() {
		log.info("@PostConstruct in DefaultTestService");
	}

}

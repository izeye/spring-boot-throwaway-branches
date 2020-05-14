package com.izeye.throwaway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.izeye.throwaway.repository.TestRepository;

/**
 * Default {@link TestService}.
 *
 * @author Johnny Lim
 */
@Service
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
		List<String> ids = Arrays.asList("test1", "test2");
		List<Thread> threads = new ArrayList<>();
		ids.forEach((id) -> {
			Thread thread = new Thread(() -> this.testRepository.get(id));
			threads.add(thread);
			thread.start();
		});
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(ex);
			}
		});
	}

}

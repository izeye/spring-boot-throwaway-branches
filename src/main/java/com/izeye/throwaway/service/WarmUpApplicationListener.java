package com.izeye.throwaway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.izeye.throwaway.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WarmUpApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

	private final TestRepository testRepository;

	public WarmUpApplicationListener(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		log.info("In onApplicationEvent(): {}", event);

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

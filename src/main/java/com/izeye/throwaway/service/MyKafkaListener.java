package com.izeye.throwaway.service;

import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by izeye on 16. 5. 16..
 */
@Data
public class MyKafkaListener {
	
	private CountDownLatch latch;
	
	@KafkaListener(topics = "my-topic")
	public void handle(String payload) {
		System.out.println(payload);
		latch.countDown();
	}
	
}

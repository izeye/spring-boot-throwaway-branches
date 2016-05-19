package com.izeye.throwaway.service;

import lombok.Data;

import java.util.concurrent.CountDownLatch;

/**
 * Created by izeye on 16. 5. 19..
 */
@Data
public class MyRabbitMqListener {
	
	private final CountDownLatch latch = new CountDownLatch(1);
	
	public void handleMessage(String message) {
		System.out.println("Consuming message: " + message);
		latch.countDown();
	}
	
}

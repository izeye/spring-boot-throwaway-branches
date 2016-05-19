package com.izeye.throwaway;

import com.izeye.throwaway.service.MyRabbitMqListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by izeye on 16. 5. 19..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApplicationTests {
	
	private static final String QUEUE_NAME = "test-queue";
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	MyRabbitMqListener myRabbitMqListener;
	
	@Test
	public void test() {
		System.out.println("Sending message...");
		this.rabbitTemplate.convertAndSend(QUEUE_NAME, "Hello, world!");
		try {
			this.myRabbitMqListener.getLatch().await();
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}

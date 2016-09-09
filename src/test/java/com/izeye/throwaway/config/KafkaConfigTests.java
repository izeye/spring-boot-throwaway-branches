package com.izeye.throwaway.config;

import com.izeye.throwaway.service.MyKafkaListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 5. 16..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class KafkaConfigTests {
	
	@Autowired
	private MyKafkaListener myKafkaListener;
	
	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Test
	public void test() {
		CountDownLatch latch = new CountDownLatch(2);
		this.myKafkaListener.setLatch(latch);

		this.kafkaTemplate.send("my-topic", 0, "Message with a parameter topic");
		this.kafkaTemplate.send(0, "Message with the default topic");
		this.kafkaTemplate.flush();

		try {
			assertThat(latch.await(60, TimeUnit.SECONDS)).isTrue();
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}

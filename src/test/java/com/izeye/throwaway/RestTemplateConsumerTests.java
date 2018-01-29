package com.izeye.throwaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateConsumerTests {

	@Autowired
	private RestTemplateConsumer consumer;

	@Test
	public void testGet() {
		String url = "https://www.google.com/";
		assertThat(this.consumer.get(url)).isNotEmpty();
	}

}

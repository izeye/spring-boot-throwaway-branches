package com.izeye.throwaway.config;

import com.izeye.throwaway.service.MyRabbitMqListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 16. 5. 19..
 */
@Configuration
public class RabbitMqConfig {

	private static final String QUEUE_NAME = "test-queue";
	
	@Bean
	public SimpleMessageListenerContainer container(
			ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMessageListener(messageListenerAdapter);
		container.setQueueNames(QUEUE_NAME);
		return container;
	}
	
	@Bean
	public MyRabbitMqListener myRabbitMqListener() {
		return new MyRabbitMqListener();
	}
	
	@Bean
	public MessageListenerAdapter messageListenerAdapter(MyRabbitMqListener myRabbitMqListener) {
		return new MessageListenerAdapter(myRabbitMqListener);
	}
	
}

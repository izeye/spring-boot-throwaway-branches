package com.izeye.throwaway.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by izeye on 16. 5. 16..
 */
@Data
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
	
	private final Consumer consumer = new Consumer();
	private final Producer producer = new Producer();
	private final Template template = new Template();
	private final Listener listener = new Listener();
	
	@Data
	public static class Consumer {
		
		private List<String> bootstrapServers;
		private String groupId;
		private Class<?> keyDeserializer;
		private Class<?> valueDeserializer;
		
	}
	
	@Data
	public static class Producer {

		private List<String> bootstrapServers;
		private Class<?> keySerializer;
		private Class<?> valueSerializer;
		
	}
	
	@Data
	public static class Template {
		
		private String defaultTopic;
		
	}
	
	@Data
	public static class Listener {
		
		private Long pollTimeout;
		
	}
	
}

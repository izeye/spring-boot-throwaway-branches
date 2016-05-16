package com.izeye.throwaway.config;

import com.izeye.throwaway.service.MyKafkaListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.SimpleKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by izeye on 16. 5. 16..
 */
@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConfig {

	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Bean
	public SimpleKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
		SimpleKafkaListenerContainerFactory<Integer, String> factory =
				new SimpleKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		
		Long pollTimeout = this.kafkaProperties.getListener().getPollTimeout();
		if (pollTimeout != null) {
			factory.setPollTimeout(pollTimeout);
		}
		return factory;
	}

	private ConsumerFactory<Integer, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(createConsumerProperties());
	}

	@Bean
	public MyKafkaListener myKafkaListener() {
		return new MyKafkaListener();
	}
	
	@Bean
	public KafkaTemplate<Integer, String> kafkaTemplate() {
		KafkaTemplate<Integer, String> template = new KafkaTemplate<>(producerFactory());
		
		String defaultTopic = this.kafkaProperties.getTemplate().getDefaultTopic();
		if (defaultTopic != null) {
			template.setDefaultTopic(defaultTopic);
		}
		return template;
	}

	private ProducerFactory<Integer, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(createProducerProperties());
	}

	private Map<String, Object> createConsumerProperties() {
		Map<String, Object> properties = new HashMap<>();
		KafkaProperties.Consumer consumer = this.kafkaProperties.getConsumer();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				consumer.getBootstrapServers());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumer.getGroupId());
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				consumer.getKeyDeserializer());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				consumer.getValueDeserializer());
		return properties;
	}

	private Map<String, Object> createProducerProperties() {
		Map<String, Object> properties = new HashMap<>();
		KafkaProperties.Producer producer = this.kafkaProperties.getProducer();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				producer.getBootstrapServers());
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				producer.getKeySerializer());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				producer.getValueSerializer());
		return properties;
	}

}

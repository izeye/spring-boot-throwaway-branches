package learningtest.org.springframework.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 5. 16..
 */
@Slf4j
public class KafkaMessageListenerContainerTests {
	
	String bootstrapServers = "localhost:9092";
	String topic = "my-topic";
	
	@Test
	public void test() {
		KafkaMessageListenerContainer<Integer, String> container = createContainer();
		final CountDownLatch latch = new CountDownLatch(4);
		container.setMessageListener((MessageListener<Integer, String>) record -> {
			log.info("Received: {}", record);
			latch.countDown();
		});
		container.setBeanName("testContainer");
		container.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
		
		KafkaTemplate<Integer, String> template = createTemplate();
		template.setDefaultTopic(topic);
		template.send(0, "foo");
		template.send(2, "bar");
		template.send(0, "baz");
		template.send(2, "qux");
		template.flush();
		try {
			assertThat(latch.await(60, TimeUnit.SECONDS)).isTrue();
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
		container.stop();
	}

	private KafkaMessageListenerContainer<Integer, String> createContainer() {
		Map<String, Object> consumerProperties = createConsumerProperties();
		ConsumerFactory<Integer, String> consumerFactory =
				new DefaultKafkaConsumerFactory<>(consumerProperties);
		return new KafkaMessageListenerContainer<Integer, String>(consumerFactory, this.topic);
	}

	private KafkaTemplate<Integer, String> createTemplate() {
		Map<String, Object> producerProperties = createProducerProperties();
		ProducerFactory<Integer, String> producerFactory =
				new DefaultKafkaProducerFactory<>(producerProperties);
		return new KafkaTemplate<Integer, String>(producerFactory);
	}

	private Map<String, Object> createConsumerProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				IntegerDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class.getName());
		return properties;
	}

	private Map<String, Object> createProducerProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				IntegerSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class.getName());
		return properties;
	}

}

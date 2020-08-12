package com.izeye.throwaway;

import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Loader for {@link Person}.
 *
 * @author Johnny Lim
 */
@Component
public class PersonLoader {

	private final ReactiveRedisConnectionFactory connectionFactory;
	private final ReactiveRedisOperations<String, Person> redisOperations;

	public PersonLoader(
			ReactiveRedisConnectionFactory connectionFactory,
			ReactiveRedisOperations<String, Person> redisOperations) {
		this.connectionFactory = connectionFactory;
		this.redisOperations = redisOperations;
	}

	@PostConstruct
	public void load() {
		connectionFactory.getReactiveConnection()
				.serverCommands().flushAll()
				.thenMany(Flux.just("Johnny", "John")
						.map((firstName) -> new Person(UUID.randomUUID().toString(), firstName, "Lim"))
						.flatMap((person) -> redisOperations.opsForValue().set(person.getId(), person)))
				.thenMany(redisOperations.keys("*").flatMap(redisOperations.opsForValue()::get))
				.subscribe(System.out::println);
	}

}

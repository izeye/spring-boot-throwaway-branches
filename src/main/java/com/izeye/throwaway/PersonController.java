package com.izeye.throwaway;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * {@link RestController} for {@link Person}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	private final ReactiveRedisOperations<String, Person> redisOperations;

	public PersonController(ReactiveRedisOperations<String, Person> redisOperations) {
		this.redisOperations = redisOperations;
	}

	@GetMapping
	public Flux<Person> findAll() {
		return redisOperations.keys("*").flatMap(redisOperations.opsForValue()::get);
	}

}

package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Tests for {@link ReactiveValueOperations}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class ReactiveValueOperationsTests {

    private final ReactiveValueOperations<String, Person> valueOperations;

    ReactiveValueOperationsTests(@Autowired ReactiveRedisTemplate<String, Person> redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Test
    void test() throws InterruptedException {
        Person person = new Person("1", "Johnny", "Lim");
        Mono<Boolean> result = this.valueOperations.set("1", person);
        StepVerifier.create(result)
                .expectNext(true)
                .verifyComplete();

        Mono<Person> found = this.valueOperations.get("1");
        StepVerifier.create(found)
                .expectNext(person)
                .verifyComplete();

        result = this.valueOperations.set("2", new Person("2", "John", "Lim"), Duration.ofSeconds(1));
        StepVerifier.create(result)
                .expectNext(true)
                .verifyComplete();

        Thread.sleep(2000L);

        found = this.valueOperations.get("2");
        StepVerifier.create(found)
                .expectNextCount(0L)
                .verifyComplete();
    }

}

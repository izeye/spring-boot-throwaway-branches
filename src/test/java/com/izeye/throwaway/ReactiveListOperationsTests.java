package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveListOperations;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Tests for {@link ReactiveListOperations}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class ReactiveListOperationsTests {

    private static final String LIST_NAME = "demo_list";

    private final ReactiveListOperations<String, String> listOperations;

    ReactiveListOperationsTests(@Autowired ReactiveStringRedisTemplate redisTemplate) {
        this.listOperations = redisTemplate.opsForList();
    }

    @Test
    void test() {
        Mono<Long> leftPush = this.listOperations.leftPushAll(LIST_NAME, "first", "second")
                .log("Pushed");
        StepVerifier.create(leftPush)
                .expectNext(2L)
                .verifyComplete();

        Mono<String> leftPop = listOperations.leftPop(LIST_NAME)
                .log("Popped");
        StepVerifier.create(leftPop)
                .expectNext("second")
                .verifyComplete();
    }

}

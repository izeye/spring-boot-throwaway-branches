package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.ReactiveKeyCommands;
import org.springframework.data.redis.connection.ReactiveStringCommands;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.nio.ByteBuffer;

/**
 * Tests for {@link ReactiveKeyCommands} and {@link ReactiveStringCommands}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class ReactiveCommandsTests {

    private final ReactiveKeyCommands keyCommands;
    private final ReactiveStringCommands stringCommands;

    @Autowired
    ReactiveCommandsTests(ReactiveKeyCommands keyCommands, ReactiveStringCommands stringCommands) {
        this.keyCommands = keyCommands;
        this.stringCommands = stringCommands;
    }

    @Test
    void test() {
        Flux<ReactiveStringCommands.SetCommand> keys = Flux.just("key1", "key2", "key3", "key4")
                .map(String::getBytes)
                .map(ByteBuffer::wrap)
                .map((key) -> ReactiveStringCommands.SetCommand.set(key).value(key));
        StepVerifier.create(stringCommands.set(keys))
                .expectNextCount(4L)
                .verifyComplete();

        Mono<Long> keyCount = keyCommands.keys(ByteBuffer.wrap("key*".getBytes()))
                .flatMapMany(Flux::fromIterable)
                .count();
        StepVerifier.create(keyCount)
                .expectNext(4L)
                .verifyComplete();
    }

}

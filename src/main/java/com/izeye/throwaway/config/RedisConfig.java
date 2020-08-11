package com.izeye.throwaway.config;

import com.izeye.throwaway.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveKeyCommands;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.ReactiveStringCommands;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * {@link Configuration} for Redis.
 *
 * @author Johnny Lim
 */
@Configuration
public class RedisConfig {

    @Bean
    public ReactiveRedisTemplate<String, Person> reactiveRedisTemplate(
            ReactiveRedisConnectionFactory connectionFactory) {
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Person> valueSerializer = new Jackson2JsonRedisSerializer<>(Person.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Person> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);
        RedisSerializationContext<String, Person> context = builder.value(valueSerializer).build();
        return new ReactiveRedisTemplate<>(connectionFactory, context);
    }

    @Bean
    public ReactiveKeyCommands keyCommands(ReactiveRedisConnectionFactory connectionFactory) {
        return connectionFactory.getReactiveConnection().keyCommands();
    }

    @Bean
    public ReactiveStringCommands stringCommands(ReactiveRedisConnectionFactory connectionFactory) {
        return connectionFactory.getReactiveConnection().stringCommands();
    }

}

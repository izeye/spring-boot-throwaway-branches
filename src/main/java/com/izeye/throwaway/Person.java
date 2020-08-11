package com.izeye.throwaway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

/**
 * Person.
 *
 * @author Johnny Lim
 */
@RedisHash
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private Long id;
	private String firstName;
	private String lastName;

}

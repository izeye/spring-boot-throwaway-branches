package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ConstructorBindingProperties}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class ConstructorBindingPropertiesTests {

	private final ConstructorBindingProperties properties;

	ConstructorBindingPropertiesTests(@Autowired ConstructorBindingProperties properties) {
		this.properties = properties;
	}

	@Test
	void test() {
		System.out.println(this.properties);

		assertThat(this.properties.getFirstName()).isEqualTo("Johnny");
		assertThat(this.properties.getLastName()).isEqualTo("Lim");
	}

}

package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SetterBindingProperties}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class SetterBindingPropertiesTests {

	private final SetterBindingProperties properties;

	SetterBindingPropertiesTests(@Autowired SetterBindingProperties properties) {
		this.properties = properties;
	}

	@Test
	void test() {
		System.out.println(this.properties);

		assertThat(this.properties.getFirstName()).isEqualTo("Johnny");
		assertThat(this.properties.getLastName()).isEqualTo("Lim");
		assertThat(this.properties.getNested().getFirst()).isEqualTo("nested first");
		assertThat(this.properties.getNested().getSecond()).isEqualTo("nested second");
		assertThat(this.properties.getInitializedNested().getFirst()).isEqualTo("initialized nested first");
		assertThat(this.properties.getInitializedNested().getSecond()).isEqualTo("initialized nested second");
	}

}

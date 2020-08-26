package com.izeye.throwaway.service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;
import lombok.Data;

/**
 * {@link ConstructorBinding}-based {@link ConfigurationProperties}.
 *
 * @author Johnny Lim
 */
@ConfigurationProperties("constructor-binding")
@ConstructorBinding
@Validated
@Data
public class ConstructorBindingProperties {

	@NotEmpty
	private final String firstName;
	@NotEmpty
	private final String lastName;

	@Valid
	private final Nested nested;

	public ConstructorBindingProperties(String firstName, String lastName, @DefaultValue Nested nested) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nested = nested;
	}

	@Data
	public static class Nested {

		@NotEmpty
		private final String first;
		@NotEmpty
		private final String second;

		public Nested(String first, String second) {
			this.first = first;
			this.second = second;
		}

	}

}

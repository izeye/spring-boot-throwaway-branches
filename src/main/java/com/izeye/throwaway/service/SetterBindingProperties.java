package com.izeye.throwaway.service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;
import lombok.Data;

/**
 * Setter-based {@link ConfigurationProperties}.
 *
 * @author Johnny Lim
 */
@ConfigurationProperties("setter-binding")
@Validated
@Data
public class SetterBindingProperties {

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;

	// Validation doesn't work.
	@Valid
	private Nested nested;

	// Validation works.
	@Valid
	private Nested initializedNested = new Nested();

	@Data
	public static class Nested {

		@NotEmpty
		private String first;
		@NotEmpty
		private String second;

	}

}

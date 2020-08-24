package com.izeye.throwaway.service;

import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ConstructorBindingProperties {

	@NotEmpty
	private final String firstName;
	@NotEmpty
	private final String lastName;

}

package com.izeye.throwaway.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * {@link ConstructorBinding}-based {@link ConfigurationProperties}.
 *
 * @author Johnny Lim
 */
@ConfigurationProperties("constructor-binding")
@ConstructorBinding
@Data
@AllArgsConstructor
public class ConstructorBindingProperties {

	private final String firstName;
	private final String lastName;

}

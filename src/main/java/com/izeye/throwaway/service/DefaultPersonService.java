package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by izeye on 16. 4. 1..
 */
@Service
public class DefaultPersonService implements PersonService {

	@Value("${message}")
	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}

}

package com.izeye.throwaway.web;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global controller exception handler.
 *
 * @author Johnny Lim
 */
@Profile("enable-controller-advice")
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RuntimeException.class)
	public void handle(RuntimeException ex) {
		System.out.println(ex);
	}

}

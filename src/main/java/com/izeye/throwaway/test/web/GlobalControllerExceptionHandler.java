package com.izeye.throwaway.test.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * {@link ControllerAdvice} for {@link org.springframework.web.servlet.mvc.Controller}s.
 *
 * @author Johnny Lim
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
		return ResponseEntity.badRequest().body("Invalid request: " + ex.getMessage());
	}

}

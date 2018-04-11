package com.izeye.throwaway;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * Global controller exception handler.
 *
 * @author Johnny Lim
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handleInvalidRequest(Throwable ex) {
		log.error("Invalid request.", ex);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.OK)
	public void handleUnexpectedError(Throwable ex) {
		log.error("Unexpected error.", ex);
	}

}

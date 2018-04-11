package com.izeye.throwaway;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * {@link RestController} for {@link SomeRequest}.
 */
@RestController
@RequestMapping(path = "/some")
@Slf4j
public class SomeController {

	@GetMapping
	public SomeResponse get(@RequestBody SomeRequest request) {
		SomeResponse response = new SomeResponse();
		response.setId(request.getId());
		return response;
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handleBadRequest(Throwable ex) {
		log.error("Bad request.", ex);
	}

}

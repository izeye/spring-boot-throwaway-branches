package com.izeye.throwaway;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
@SuppressWarnings("deprecation")
public class JsonpControllerAdvice extends AbstractJsonpResponseBodyAdvice {

	public JsonpControllerAdvice() {
		super("callback");
	}

}

package com.izeye.throwaway.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * {@link RestController} for performance tests.
 *
 * @author Jungmuk Lim
 */
@RestController
@RequestMapping("/performance-tests")
public class PerformanceTestController {

	@GetMapping
	public String delay(@RequestParam long delayInMillis, HttpServletResponse response) {
		response.setHeader("Connection", "Close");
		try {
			Thread.sleep(delayInMillis);
			return String.valueOf(delayInMillis);
		}
		catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}

}

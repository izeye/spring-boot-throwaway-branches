package com.izeye.throwaway.web;

import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * Test {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestRestController {

	@GetMapping("/request-header")
	public String requestHeader(@RequestHeader(name = "X-Test", required = false) String test) {
		log.info("test: {}", test);
		return test;
	}

	@GetMapping("/sleep")
	public String sleep(@RequestParam int seconds) throws InterruptedException {
		TimeUnit.SECONDS.sleep(seconds);
		return "Slept for " + seconds + " seconds.";
	}

}

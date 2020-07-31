package com.izeye.throwaway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Home {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello, world!";
	}

	@GetMapping("/throwException")
	public String throwException() {
		throw new RuntimeException("Expected.");
	}

	@GetMapping("/boom")
	public Mono<String> boom() {
		return Flux.just("boom1", "boom2")
				.single()
				.checkpoint("afterSingle")
				.subscribeOn(Schedulers.parallel());
	}

}

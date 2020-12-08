package com.izeye.throwaway;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationStartupAware;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.metrics.StartupStep;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Home {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/")
public class HomeController implements ApplicationStartupAware {

	private final RestTemplate restTemplate;
	private ApplicationStartup applicationStartup;

	public HomeController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostConstruct
	public void init() throws InterruptedException {
		StartupStep startupStep = applicationStartup.start("home.controller.post.construct");
		TimeUnit.SECONDS.sleep(1);
		startupStep.end();
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello, world!";
	}

	@GetMapping("/httpServletRequest")
	public Map<String, Map<String, ?>> httpServletRequest(HttpServletRequest request) {
		Map<String, Map<String, ?>> response = new LinkedHashMap<>();
		response.put("parameters", request.getParameterMap());
		return response;
	}

	@GetMapping("/throwException")
	public String throwException() {
		throw new RuntimeException("Expected.");
	}

	@GetMapping("/invokeRestTemplate")
	public String invokeRestTemplate() {
		return this.restTemplate.getForObject("https://www.google.com/", String.class);
	}

	@Override
	public void setApplicationStartup(ApplicationStartup applicationStartup) {
		this.applicationStartup = applicationStartup;
	}
}

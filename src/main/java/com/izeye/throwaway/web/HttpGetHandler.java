package com.izeye.throwaway.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * HTTP GET handler.
 *
 * @author Johnny Lim
 */
@Component
public class HttpGetHandler {

	@Autowired
	private RestTemplate restTemplate;

	public Mono<ServerResponse> httpGet(ServerRequest request) {
		String url = request.queryParam("url").get();
		String response = this.restTemplate.getForObject(url, String.class);
		return ServerResponse.ok().contentType(MediaType.TEXT_HTML)
				.body(Mono.just(response), String.class);
	}

}

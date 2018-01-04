package com.izeye.throwaway.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.izeye.throwaway.web.EchoHandler;
import com.izeye.throwaway.web.HttpGetHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * {@link Configuration} for web.
 *
 * @author Johnny Lim
 */
@Configuration
public class WebConfig {

	@Bean
	public RouterFunction<ServerResponse> echoRouterFunction(EchoHandler echoHandler) {
		return route(POST("/echo"), echoHandler::echo);
	}

	@Bean
	public RouterFunction<ServerResponse> httpGetRouterFunction(HttpGetHandler httpGetHandler) {
		return route(GET("/httpGet"), httpGetHandler::httpGet);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

}

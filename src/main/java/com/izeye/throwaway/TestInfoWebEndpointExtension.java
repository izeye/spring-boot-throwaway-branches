package com.izeye.throwaway;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

/**
 * Test {@link EndpointWebExtension} for {@link InfoEndpoint}.
 *
 * @author Johnny Lim
 */
@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class TestInfoWebEndpointExtension {

	private final InfoEndpoint delegate;

	public TestInfoWebEndpointExtension(InfoEndpoint delegate) {
		this.delegate = delegate;
	}

	@ReadOperation
	public Map<String, Object> info() {
		return Collections.singletonMap("message", "Hello, world!");
	}

}

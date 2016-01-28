package com.izeye.throwaway.trace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by izeye on 16. 1. 28..
 */
@Component
public class CustomTraceEndpoint extends AbstractEndpoint<List<Trace>> {
	
	@Autowired
	private CustomTraceService customTraceService;

	public CustomTraceEndpoint() {
		super("custom_trace");
	}

	@Override
	public List<Trace> invoke() {
		return customTraceService.findAll();
	}
	
}

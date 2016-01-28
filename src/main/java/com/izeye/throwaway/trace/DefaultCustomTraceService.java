package com.izeye.throwaway.trace;

import org.springframework.boot.actuate.trace.Trace;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by izeye on 16. 1. 28..
 */
@Service
public class DefaultCustomTraceService implements CustomTraceService {

	private static final int CAPACITY = 100;

	private final List<Trace> traces = new LinkedList<>();
	
	@Override
	public List<Trace> findAll() {
		synchronized (this.traces) {
			return Collections.unmodifiableList(new ArrayList<>(this.traces));
		}
	}

	@Override
	public void add(Map<String, Object> info) {
		Trace trace = new Trace(new Date(), info);
		synchronized (this.traces) {
			while (this.traces.size() >= CAPACITY) {
				this.traces.remove(CAPACITY - 1);
			}
			this.traces.add(0, trace);
		}
	}
	
}

package com.izeye.throwaway.trace;

import org.springframework.boot.actuate.trace.Trace;

import java.util.List;
import java.util.Map;

/**
 * Created by izeye on 16. 1. 28..
 */
public interface CustomTraceService {

	List<Trace> findAll();

	void add(Map<String, Object> info);
	
}

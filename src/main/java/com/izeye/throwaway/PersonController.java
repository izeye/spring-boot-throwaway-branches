package com.izeye.throwaway;

import com.izeye.throwaway.trace.CustomTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by izeye on 15. 10. 1..
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {
	
	@Autowired
	private CustomTraceService customTraceService;
	
	@Autowired
	private TraceRepository traceRepository;
	
	private int i = 0;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getAll() {
		Map<String, Object> trace = new HashMap<>();
		trace.put("id", i++);
		customTraceService.add(trace);

		traceRepository.add(trace);
		
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Johnny");
		person.setLastName("Lim");
		person.setAge(35);
		person.setCreatedTime(new Date());
		
		return Collections.singletonList(person);
	}
	
}

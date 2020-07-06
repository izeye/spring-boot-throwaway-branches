package com.izeye.throwaway;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/**
 * {@link WebEndpoint} for testing.
 *
 * @author Johnny Lim
 */
@Component
@WebEndpoint(id = "test")
public class TestEndpoint {

	@ReadOperation
	public Map<String, String> test(String firstName, String lastName) {
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		return map;
	}

}

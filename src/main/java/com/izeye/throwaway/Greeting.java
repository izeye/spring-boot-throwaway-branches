package com.izeye.throwaway;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by izeye on 15. 12. 12..
 */
@Data
public class Greeting extends ResourceSupport {
	
	private final String content;
	
	public Greeting(String content) {
		this.content = content;
	}
	
}

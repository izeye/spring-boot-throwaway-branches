package com.izeye.throwaway;

import com.izeye.throwaway.config.AnotherPrototypeObject;
import com.izeye.throwaway.config.PrototypeObject;
import com.izeye.throwaway.config.SingletonObject;
import com.izeye.throwaway.config.SmartPrototypeObject;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by izeye on 16. 7. 19..
 */
@RestController
@RequestMapping(path = "/test/bean-scope")
public class BeanScopeTestController {
	
	@Autowired
	private ObjectProvider<PrototypeObject> prototypeObjectProvider;

	@Autowired
	private ObjectProvider<SmartPrototypeObject> smartPrototypeObjectProvider;

	@Autowired
	private ObjectProvider<AnotherPrototypeObject> anotherPrototypeObjectProvider;
	
	@Autowired
	private ObjectProvider<SingletonObject> singletonObjectProvider;
	
	@GetMapping("/prototype-object")
	public String prototypeObject() {
		return this.prototypeObjectProvider.getIfAvailable().toString();
	}
	
	@GetMapping("/smart-prototype-object")
	public String smartPrototypeObject() {
		return this.smartPrototypeObjectProvider.getIfAvailable().toString();
	}
	
	@GetMapping("/another-prototype-object")
	public String anotherPrototypeObject() {
		return this.anotherPrototypeObjectProvider.getIfAvailable().toString();
	}

	@GetMapping("/singleton-object")
	public String singletonObject() {
		return this.singletonObjectProvider.getIfAvailable().toString();
	}
	
}

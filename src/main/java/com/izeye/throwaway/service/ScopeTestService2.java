package com.izeye.throwaway.service;

import com.izeye.throwaway.domain.PrototypeObject;
import com.izeye.throwaway.domain.SingletonObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by izeye on 16. 7. 18..
 */
@Service
@Data
public class ScopeTestService2 {
	
	@Autowired
	private SingletonObject singletonObject;

	@Autowired
	private PrototypeObject prototypeObject;
	
}

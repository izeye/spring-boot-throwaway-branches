package com.izeye.throwaway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 7. 18..
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ScopeTestServiceTests {
	
	@Autowired
	ScopeTestService1 someObjectService1;
	
	@Autowired
	ScopeTestService2 someObjectService2;
	
	@Test
	void test() {
		assertThat(this.someObjectService1.getSingletonObject())
				.isSameAs(this.someObjectService2.getSingletonObject());
		
		assertThat(this.someObjectService1.getPrototypeObject())
				.isNotSameAs(this.someObjectService2.getPrototypeObject());
	}
	
}

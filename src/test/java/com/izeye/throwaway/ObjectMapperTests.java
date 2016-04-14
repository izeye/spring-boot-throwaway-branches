package com.izeye.throwaway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by izeye on 16. 4. 14..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ObjectMapperTests {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void test() throws JsonProcessingException {
		LombokAllArgsConstructorDomain lombokDomain = new LombokAllArgsConstructorDomain();
		lombokDomain.setSomeProperty("test");
		String lombokJson = this.objectMapper.writeValueAsString(lombokDomain);
		System.out.println(lombokJson);
		
		ManualAllArgsConstructorDomain manualDomain = new ManualAllArgsConstructorDomain();
		manualDomain.setSomeProperty("test");
		String manualJson = this.objectMapper.writeValueAsString(manualDomain);
		System.out.println(manualJson);
	}
	
}
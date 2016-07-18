package com.izeye.throwaway.config;

import com.izeye.throwaway.domain.PrototypeObject;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by izeye on 16. 7. 18..
 */
public class PrototypeObjectFactoryBean implements FactoryBean<PrototypeObject> {
	
	@Override
	public PrototypeObject getObject() throws Exception {
		return new PrototypeObject();
	}

	@Override
	public Class<?> getObjectType() {
		return PrototypeObject.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
}

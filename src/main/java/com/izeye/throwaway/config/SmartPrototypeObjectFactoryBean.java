package com.izeye.throwaway.config;

import org.springframework.beans.factory.SmartFactoryBean;

/**
 * Created by izeye on 16. 7. 19..
 */
public class SmartPrototypeObjectFactoryBean
		implements SmartFactoryBean<SmartPrototypeObject> {
	
	@Override
	public boolean isPrototype() {
		return true;
	}

	@Override
	public boolean isEagerInit() {
		return false;
	}

	@Override
	public SmartPrototypeObject getObject() throws Exception {
		return new SmartPrototypeObject();
	}

	@Override
	public Class<?> getObjectType() {
		return SmartPrototypeObject.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
}

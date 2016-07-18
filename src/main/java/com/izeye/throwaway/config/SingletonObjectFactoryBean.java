package com.izeye.throwaway.config;

import com.izeye.throwaway.domain.SingletonObject;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by izeye on 16. 7. 18..
 */
public class SingletonObjectFactoryBean implements FactoryBean<SingletonObject> {
	
	@Override
	public SingletonObject getObject() throws Exception {
		return new SingletonObject();
	}

	@Override
	public Class<?> getObjectType() {
		return SingletonObject.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}

package com.izeye.throwaway;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.izeye.throwaway:type=MyType,name=My Name")
public class MyManagedResource {

	@ManagedAttribute
	public double getMyManagedAttribute() {
		return ThreadLocalRandom.current().nextDouble();
	}

}

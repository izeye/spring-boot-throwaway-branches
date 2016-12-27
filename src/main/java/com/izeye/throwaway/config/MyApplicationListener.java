package com.izeye.throwaway.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Sample {@link MyApplicationListener}.
 *
 * @author Johnny Lim
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	@PostConstruct
	public void postConstruct() {
		System.out.println(">>>>> @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(">>>>> @PreDestroy");
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(">>>>> " + event);
	}

}

package com.izeye.throwaway;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample {@link ApplicationListener}.
 *
 * @author Johnny Lim
 */
@Component
@Slf4j
public class SampleApplicationListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info("SampleApplicationListener.onApplicationEvent() has been invoked with {}.", event);
		if (event instanceof AvailabilityChangeEvent) {
			AvailabilityChangeEvent availabilityChangeEvent = (AvailabilityChangeEvent) event;
			log.info("AvailabilityChangeEvent.getState(): {}", availabilityChangeEvent.getState());
		}
	}

}

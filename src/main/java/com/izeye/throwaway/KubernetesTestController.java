package com.izeye.throwaway;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} for testing Kubernetes.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/kubernetes-test")
public class KubernetesTestController {

	private final ApplicationEventPublisher publisher;

	public KubernetesTestController(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@GetMapping("/down")
	public String down() {
		AvailabilityChangeEvent.publish(publisher, this, ReadinessState.REFUSING_TRAFFIC);
		return "down";
	}

	@GetMapping("/up")
	public String up() {
		AvailabilityChangeEvent.publish(publisher, this, ReadinessState.ACCEPTING_TRAFFIC);
		return "up";
	}

}

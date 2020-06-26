package com.izeye.throwaway;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * A sample {@link HealthIndicator}.
 *
 * @author Johnny Lim
 */
@Component
public class SomeHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().build();
	}

}

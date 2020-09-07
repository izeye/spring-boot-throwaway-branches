package com.izeye.throwaway;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * Default {@link SampleService}.
 *
 * @author Johnny Lim
 */
@Service
@Slf4j
public class DefaultSampleService implements SampleService {

	@PostConstruct
	public void init() {
		log.info("DefaultSampleService.init() has been invoked.");
	}

	@Override
	public void doService() {
	}

}

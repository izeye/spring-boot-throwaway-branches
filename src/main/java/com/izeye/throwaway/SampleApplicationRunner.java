package com.izeye.throwaway;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample {@link ApplicationRunner}.
 *
 * @author Johnny Lim
 */
@Component
@Slf4j
public class SampleApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		log.info("SampleApplicationRunner.run() has been invoked.");
	}

}

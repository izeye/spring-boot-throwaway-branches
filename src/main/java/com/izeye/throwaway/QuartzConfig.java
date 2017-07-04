package com.izeye.throwaway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * Configuration for Quartz.
 *
 * @author Johnny Lim
 */
@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail sampleJobDetail() {
		return JobBuilder.newJob().ofType(SampleJob.class).withIdentity("sampleJob")
				.usingJobData("name", "world")
				.storeDurably().build();
	}

	@Bean
	public Trigger sampleTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever();
		return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger")
				.withSchedule(scheduleBuilder).build();
	}

}

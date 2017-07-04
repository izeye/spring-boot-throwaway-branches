package com.izeye.throwaway;

import org.springframework.scheduling.quartz.QuartzJobBean;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Sample job.
 *
 * @author Johnny Lim
 */
public class SampleJob extends QuartzJobBean {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.printf("Hello, %s!%n", this.name);
	}
	
}

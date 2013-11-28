package com.xhsoft.framework.scheduler.job;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class SyncDataJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	}
}

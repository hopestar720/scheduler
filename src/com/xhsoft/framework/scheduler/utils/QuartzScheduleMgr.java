package com.xhsoft.framework.scheduler.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;

public interface QuartzScheduleMgr {
	
	static final String DEFAULT_JOB_GROUP = "job_group_1";
    static final String DEFAULT_TRIGGER_GROUP = "trigger_group_1";
    

    
	public void addJob();
	public void addJobs();
	
	public void removeJob();
	public void removeJobs();
	
	public void pauseJob();
	public void pauseJobs();
	
	public void resumeJob();
	public void resumeJobs();
	
	public void triggerJob();
	
	public void pauseTrigger();
	public void pauseTriggers();
	
	public void resumeTrigger();
	public void resumeTriggers();
	
	public void pauseAll();
	public void resumeAll();
	
	public void secheduleJob(JobDetail jobDetail);
	public void scheduleJobs();
	
	public void unscheduleJob();
	public void unscheduleJobs();
	
	public void rescheduleJob();
	public void rescheduleJobs();
	
	public void startup();
	public void shutdown();

}

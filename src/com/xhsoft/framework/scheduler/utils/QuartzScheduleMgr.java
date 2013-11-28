package com.xhsoft.framework.scheduler.utils;

import java.util.List;
import java.util.Map;

import org.quartz.JobDetail;

import com.xhsoft.framework.scheduler.entity.JobInfo;

public interface QuartzScheduleMgr {
	
	static final String DEFAULT_JOB_GROUP = "job_group_1";
    static final String DEFAULT_TRIGGER_GROUP = "trigger_group_1";
    
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String EXIST = "exist";
    public static final String NO_EXIST = "no_exist";
    

    
	public String addJob(JobInfo job);
	public Map<String,String> addJobs(List<JobInfo> jobs);
	
	public String removeJob(JobInfo job);
	public Map<String,String> removeJobs(List<JobInfo> jobs);
	
	public String pauseJob(JobInfo job);
	public Map<String,String> pauseJobs(List<JobInfo> jobs);
	
	public String resumeJob(JobInfo job);
	public Map<String,String> resumeJobs();
	
	public void triggerJob();
	
	public String pauseTrigger();
	public Map<String,String> pauseTriggers();
	
	public String resumeTrigger();
	public Map<String,String> resumeTriggers();
	
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

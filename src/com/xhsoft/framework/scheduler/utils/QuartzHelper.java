package com.xhsoft.framework.scheduler.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzHelper {
	
	private static final Log logger = LogFactory.getLog(QuartzHelper.class);
	
	private static QuartzHelper instance;
	
	// Initiate a Schedule Factory
    private SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    // Retrieve a scheduler from schedule factory
    private Scheduler scheduler = null;
    
    private static final String DEFAULT_JOB_GROUP = "job_group_1";
    private static final String DEFAULT_TRIGGER_GROUP = "trigger_group_1";

	
	private QuartzHelper(){
		try {
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized QuartzHelper getInstance(){
		if(instance == null){
			instance = new QuartzHelper();
		}
		return instance;
	}
	
	public void addJob(JobDetail jobDetail){
		
	}
	
	public void addJobs(){
		Map<JobDetail, Set<? extends Trigger>> jobs = new HashMap<JobDetail, Set<? extends Trigger>>();
		try {
			scheduler.scheduleJobs(jobs,true);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyJob(){
		scheduler.
	}
	
	public void removeJob(){}
	
	public void startup(){
		try {
			if(scheduler.isStarted())
				return;
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown(){
		try {
			if(scheduler.isShutdown())
				return;
			scheduler.shutdown(true);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}

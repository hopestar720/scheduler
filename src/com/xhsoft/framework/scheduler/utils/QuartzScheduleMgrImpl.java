package com.xhsoft.framework.scheduler.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;


public class QuartzScheduleMgrImpl implements QuartzScheduleMgr{
	
	private static final Log logger = LogFactory.getLog(QuartzScheduleMgrImpl.class);
	
    // Retrieve a scheduler from schedule factory
    private Scheduler scheduler = null;
    
	public void addJob(){
		scheduler.addJob(jd, arg1);
	}
	public void addJobs(){
		scheduler.addJob(arg0, arg1, arg2);
	}
	
	public void modifyJob(){
	}
	
	public void removeJob(){
		scheduler.deleteJob(jk);
	}
	
	public void removeJobs(){
		List<JobKey> jks = new ArrayList<JobKey>();
		try {
			scheduler.deleteJobs(jks);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerJob(){
		scheduler.triggerJob(arg0, arg1);
	}
	
	public void pauseJob(){
		JobKey jk;
		scheduler.pauseJob(jk);
	}
	
	public void pauseJobs(){
		GroupMatcher<JobKey> gm;
		scheduler.pauseJobs(gm);
	}
	
	public void pauseTrigger(){
		TriggerKey tk;
		scheduler.pauseTrigger(tk);
	}
	public void pauseTriggers(){
		GroupMatcher<TriggerKey> gm;
		scheduler.pauseTriggers(gm);
	}
	
	public void pauseAll(){
		scheduler.pauseAll();
	}
	
	public void resumeJob(){
		scheduler.resumeJob(arg0);
	}
	public void resumeJobs(){
		scheduler.resumeJobs(arg0);
	}
	public void resumeTrigger(){
		scheduler.resumeJob(arg0);
	}
	public void resumeTriggers(){
		scheduler.resumeJob(arg0);
	}
	public void resumeAll(){
		scheduler.resumeAll();
	}
	
	public void secheduleJob(JobDetail jobDetail){
		
	}
	
	public void scheduleJobs(){
		Map<JobDetail, Set<? extends Trigger>> jobs = new HashMap<JobDetail, Set<? extends Trigger>>();
		try {
			scheduler.scheduleJobs(jobs,true);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void unscheduleJob(){
		TriggerKey tk = null;
		try {
			scheduler.unscheduleJob(tk);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void unscheduleJobs(){
		List<TriggerKey> tks = new ArrayList<TriggerKey>();
		try {
			scheduler.unscheduleJobs(tks );
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void rescheduleJob(){
		TriggerKey tk = null;
		Trigger t = null;
		try {
			scheduler.rescheduleJob(tk, t);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void rescheduleJobs(){
		Map<TriggerKey,Trigger> tks = new HashMap<TriggerKey,Trigger>();
		try {
			for(Entry<TriggerKey, Trigger> entry : tks.entrySet()){
				scheduler.rescheduleJob(entry.getKey(), entry.getValue());
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	
	
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

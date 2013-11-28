package com.xhsoft.framework.scheduler.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.xhsoft.framework.scheduler.entity.JobInfo;
import com.xhsoft.framework.scheduler.entity.TriggerInfo;


public class QuartzHelper {
	
	private static final Log logger = LogFactory.getLog(QuartzHelper.class);
	
	private static QuartzHelper instance;
	
	
    // Retrieve a scheduler from schedule factory
    private Scheduler scheduler = null;
    
    public static final String DEFAULT_JOB_GROUP = "job_group_1";
    public static final String DEFAULT_TRIGGER_GROUP = "trigger_group_1";
    
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String EXIST = "exist";
    public static final String NO_EXIST = "no_exist";
    

	
	private QuartzHelper(){
		// Initiate a Schedule Factory
	    SchedulerFactory schedulerFactory = new StdSchedulerFactory();
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
	
	/**
	 * 添加任务对象（单个）
	 * @param job
	 * @return 执行结果
	 * @author hopestar720@126.com
	 * @since 2013年11月28日
	 */
	public String addJob(JobInfo job){
		JobDetailImpl jobDetail = new JobDetailImpl();
		try {
			JobKey key = new JobKey(Long.toString(job.getId()));
			if(scheduler.checkExists(key)){
				return EXIST;
			}
			jobDetail.setKey(key);
			jobDetail.setName(job.getName());
			//映射Job类
			jobDetail.setJobClass((Class<? extends Job>) Class.forName(job.getClassName()));
			JobDataMap jobDataMap = new JobDataMap(job.getDataMap());
			jobDetail.setJobDataMap(jobDataMap );
			jobDetail.setGroup(job.getGroup().getName());
			scheduler.addJob(jobDetail , true, true);
			return SUCCESS;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return FAILURE;
	}
	
	/**
	 * 添加任务对象（多个）
	 * @param jobs
	 * @return 执行记录Map集合
	 * @author hopestar720@126.com
	 * @since 2013年11月28日
	 */
	public Map<String,String> addJobs(List<JobInfo> jobs){
		//保留执行记录
		Map<String,String> records = new HashMap<String,String>();
		for(JobInfo job : jobs){
			String result = addJob(job);
			records.put(Long.toString(job.getId()), result);
		}
		return records;
	}
	
	public void modifyJob(){
	}
	
	/**
	 * 删除任务（单个）
	 * @param job
	 * @return 执行结果
	 * @author hopestar720@126.com
	 * @since 2013年11月28日
	 */
	public String removeJob(JobInfo job){
		JobKey key = new JobKey(Long.toString(job.getId()));
		try {
			if(!scheduler.checkExists(key))
				return NO_EXIST;
			
			scheduler.deleteJob(key);
			return SUCCESS;
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return FAILURE;
	}
	
	/**
	 * 删除任务（多个）
	 * @param jobs
	 * @return 执行结果记录集合
	 * @author hopestar720@126.com
	 * @since 2013年11月28日
	 */
	public Map<String,String> removeJobs(List<JobInfo> jobs){
		//执行记录集合
		Map<String,String> records = new HashMap<String,String>();
		for(JobInfo job : jobs){
			records.put(Long.toString(job.getId()), removeJob(job));
		}
		return records;
	}
	
	public void triggerJob(){
		//scheduler.triggerJob(arg0, arg1);
	}
	
	public String pauseJob(JobInfo job){
		try {
			JobKey key = new JobKey(Long.toString(job.getId()));
			if(!scheduler.checkExists(key))
				return NO_EXIST;
			scheduler.pauseJob(key);
			return SUCCESS;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return FAILURE;
	}
	
	public void pauseJobs(List<JobInfo> jobs){
		
	}
	
	public String pauseTrigger(TriggerInfo trigger){
		try {
			TriggerKey key = new TriggerKey(Long.toString(trigger.getId()));
			if(!scheduler.checkExists(key))
				return NO_EXIST;
			scheduler.pauseTrigger(key);
			return SUCCESS;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return FAILURE;
	}
	public void pauseTriggers(){
		
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

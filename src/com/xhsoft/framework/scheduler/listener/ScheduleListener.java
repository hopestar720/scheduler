package com.xhsoft.framework.scheduler.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xhsoft.framework.scheduler.utils.QuartzHelper;

public class ScheduleListener implements ServletContextListener {
	
	private static final Log logger = LogFactory.getLog(ScheduleListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("任务调度器关闭...");
		QuartzHelper.getInstance().shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("开始启动任务调度器...");
		QuartzHelper.getInstance().startup();

	}

}

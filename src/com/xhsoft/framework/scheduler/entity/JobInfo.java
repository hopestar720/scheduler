package com.xhsoft.framework.scheduler.entity;

import java.io.Serializable;
import java.util.Map;

public class JobInfo implements Serializable{
	
	private Long id;
	private String name;
	private String className;
	private Map<String,Object> dataMap;
	private String remark;
	
	private JobGroupInfo group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public JobGroupInfo getGroup() {
		return group;
	}

	public void setGroup(JobGroupInfo group) {
		this.group = group;
	}

	public Map<String,Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}

}

package com.xhsoft.framework.scheduler.entity;

import java.io.Serializable;

public class JobGroupInfo implements Serializable {
	
	private long id;
	private String name;
	private String reamrk;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReamrk() {
		return reamrk;
	}
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}

}

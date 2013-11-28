/**
 * Copyright (c) 2013, hopestar720 and/or its affiliates. All rights reserved.
 * hopestar720 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.xhsoft.framework.base.action;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionServlet;
import org.springframework.web.struts.ActionSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.xhsoft.framework.base.entity.AbstractEntity;

/**
 * @author hopestar720@126.com
 * @since 2013年11月28日
 * 
 */
public class BaseAction<T extends AbstractEntity> extends ActionSupport
		implements Preparable, ModelDriven<T> {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public T getModel() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() throws Exception {
	}
	
	public ServletRequest getRequest(){
	}

}

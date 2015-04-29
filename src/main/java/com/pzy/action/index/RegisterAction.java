package com.pzy.action.index;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.User;

@ParentPackage("struts-default")  
public class RegisterAction extends ActionSupport{
	private User user;

	@Action(value = "/registerUser", results = { @Result(name = "success", location = "/WEB-INF/views/registerok.jsp") })
	public String registerUser() throws Exception {
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

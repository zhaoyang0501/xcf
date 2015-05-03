package com.pzy.action.index;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.Collect;
import com.pzy.entity.CookBook;
import com.pzy.entity.CookFood;
import com.pzy.entity.CookStep;
import com.pzy.entity.User;
import com.pzy.service.CollectService;
import com.pzy.service.CookBookService;
import com.pzy.service.UserService;

@ParentPackage("json-default")
@Namespace("/")
public class DetailAction extends ActionSupport{
	private CookBook cookBook;
	private String tip;
	@Autowired
	CookBookService cookBookService;
	@Autowired
	CollectService collectService;
	public String execute() throws Exception {
		cookBook=cookBookService.find(cookBook.getId());
		return SUCCESS;
	}
	@Action(value = "saveCollect", results = { @Result(name = "success", type = "json") }, params = {
			"contentType", "text/html" })
	public String saveCollect(){
		Collect collect=new Collect();
		collect.setCookBook(cookBookService.find(cookBook.getId()));
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		collect.setUser(user);
		collectService.save(collect);
		tip="ok";
		return SUCCESS;
	}
	public CookBook getCookBook() {
		return cookBook;
	}
	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
}
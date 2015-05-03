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
import com.pzy.entity.CookBook;
import com.pzy.entity.CookFood;
import com.pzy.entity.CookStep;
import com.pzy.entity.User;
import com.pzy.service.CookBookService;
import com.pzy.service.UserService;

@ParentPackage("struts-default")  
@Namespace("/")
public class IndexAction extends ActionSupport{
	private List<CookBook> cookBookNews;
	private List<CookBook> cookBookHots;
	@Autowired
	CookBookService cookBookService;
	public String execute() throws Exception {
		cookBookNews=cookBookService.findNew();
		cookBookHots=cookBookService.findHot();
		return SUCCESS;
	}
	public List<CookBook> getCookBookNews() {
		return cookBookNews;
	}
	public void setCookBookNews(List<CookBook> cookBookNews) {
		this.cookBookNews = cookBookNews;
	}
	public List<CookBook> getCookBookHots() {
		return cookBookHots;
	}
	public void setCookBookHots(List<CookBook> cookBookHots) {
		this.cookBookHots = cookBookHots;
	}
}

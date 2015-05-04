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
import com.pzy.entity.Category;
import com.pzy.entity.CookBook;
import com.pzy.entity.CookFood;
import com.pzy.entity.CookStep;
import com.pzy.entity.User;
import com.pzy.service.CategoryService;
import com.pzy.service.CookBookService;
import com.pzy.service.UserService;

@ParentPackage("struts-default")  
@Namespace("/")
public class SearchAction extends ActionSupport{
	private List<CookBook> cookBooks;
	private List<Category> categorys;
	private String key;
	@Autowired
	CookBookService cookBookService;
	@Autowired
	CategoryService categoryService;
	public String execute() throws Exception {
		cookBooks=cookBookService.findAll(1, 1000,key).getContent();
		categorys=categoryService.findCategorys();
		return SUCCESS;
	}
	public List<CookBook> getCookBooks() {
		return cookBooks;
	}
	public void setCookBooks(List<CookBook> cookBooks) {
		this.cookBooks = cookBooks;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}

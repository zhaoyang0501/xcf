package com.pzy.action.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.CookBook;
import com.pzy.entity.User;
import com.pzy.service.CookBookService;
import com.pzy.service.UserService;

@Namespace("/admin/cookbook")
@ParentPackage("json-default")  
public class CookBookAction  extends ActionSupport{
     private Integer sEcho=1;
     private Integer iDisplayStart=0;
     private Integer iDisplayLength=10;
     private String name;
     private Long id;
     private CookBook cookBook;
	private Map<String,Object> resultMap= new HashMap<String,Object>();
     @Autowired
     private CookBookService cookBookService;
     @Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/admin/cookbook/index.jsp") }) 
     public String index(){
          return SUCCESS;
     }
     
    @Action(value = "list", results = { @Result(name = "success", type = "json") }, params = { "contentType", "text/html" })  
     public String list(){
         int pageNumber = (int) (iDisplayStart / iDisplayLength) + 1;
          int pageSize = iDisplayLength;
          Page<CookBook> list = cookBookService.findAll(pageNumber, pageSize, name);
          resultMap.put("aaData", list.getContent());
          resultMap.put("iTotalRecords", list.getTotalElements());
          resultMap.put("iTotalDisplayRecords", list.getTotalElements());
          resultMap.put("sEcho", sEcho);
          return SUCCESS;
     }
     
    @Action(value = "delete", results = { @Result(name = "success", type = "json") }, params = { "contentType", "text/html" })  
        public String delete(){
         try {
        	 cookBookService.delete(id);
			 resultMap.put("state", "success");
	         resultMap.put("msg", "删除成功");
		} catch (Exception e) {
			 resultMap.put("state", "error");
	         resultMap.put("msg", "删除失败，外键约束");
		}
         
             return SUCCESS;
        }
    @Action(value = "get", results = { @Result(name = "success", type = "json") }, params = { "contentType", "text/html" })  
    public String get(){
     resultMap.put("object", cookBookService.find(id));
     resultMap.put("state", "success");
     resultMap.put("msg", "删除成功");
         return SUCCESS;
    }
    
    @Action(value = "update", results = { @Result(name = "success", type = "json") }, params = { "contentType", "text/html" })  
    public String update(){
    CookBook cookBookToupdate= cookBookService.find(cookBook.getId());
    cookBookToupdate.setCategory(cookBook.getCategory());
    cookBookToupdate.setCategorySub(cookBook.getCategorySub());
    cookBookToupdate.setCount(cookBook.getCount());
    cookBookToupdate.setName(cookBook.getName());
    cookBookToupdate.setRemark(cookBook.getRemark());
    cookBookToupdate.setScore(cookBook.getScore());
    cookBookService.save(cookBookToupdate);
     resultMap.put("state", "success");
     resultMap.put("msg", "修改成功");
     return SUCCESS;
    }
     /*~~~~~~~~get and setter~~~~~~~~~*/
     @JSON  
     public Map<String,Object> getResultMap() {
          return resultMap;
     }

     public void setResultMap(Map<String,Object> resultMap) {
          this.resultMap = resultMap;
     }
     public Integer getSEcho() {
 		return sEcho;
 	}

 	public void setSEcho(Integer sEcho) {
 		this.sEcho = sEcho;
 	}

 	public Integer getIDisplayStart() {
 		return iDisplayStart;
 	}

 	public void setIDisplayStart(Integer idisplayStart) {
 		this.iDisplayStart = idisplayStart;
 	}

 	public Integer getIDisplayLength() {
 		return iDisplayLength;
 	}

 	public void setIDisplayLength(Integer iDisplayLength) {
 		this.iDisplayLength = iDisplayLength;
 	}

     public String getName() {
          return name;
     }

     public void setName(String userName) {
          this.name = userName;
     }
     public Long getId() {
          return id;
     }
     public void setId(Long id) {
          this.id = id;
     }
     public CookBook getCookBook() {
 		return cookBook;
 	}
 	public void setCookBook(CookBook cookBook) {
 		this.cookBook = cookBook;
 	}
}

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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.CookBook;
import com.pzy.entity.CookFood;
import com.pzy.entity.CookStep;
import com.pzy.entity.MsgBoard;
import com.pzy.entity.User;
import com.pzy.service.CookBookService;
import com.pzy.service.MsgCategoryService;
import com.pzy.service.UserService;

@ParentPackage("struts-default")  
@Namespace("/")
public class CenterAction extends ActionSupport{
	private User user;
	private String tip;
	private CookBook cookBook;
	private List<CookFood> cookFoods;
	private List<CookStep> cookSteps;
	private List<CookBook> cookBooks;
	private File cookImg;
	private String cookImgContentType;  
    private String cookImgFileName; 
	
    private File[] stepImg;
	private String[] stepImgContentType;  
    private String[] stepImgFileName; 
    private MsgBoard msgBoard;
    private List<MsgBoard> msgBoards;
	@Autowired
	UserService userService;
	@Autowired
	CookBookService cookBookService;
	@Autowired
	MsgCategoryService msgCategoryService;
	
	@Action(value = "/center", results = { @Result(name = "success", location = "/WEB-INF/views/center.jsp") })
	public String center(){
		return SUCCESS;
	}
	@Action(value = "/centerCookBook", results = { @Result(name = "success", location = "/WEB-INF/views/center_cookbook.jsp") })
	public String centerCookBook(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		cookBooks=cookBookService.findByUser(user);
		return SUCCESS;
	}
	@Action(value = "/centerMsgBoard", results = { @Result(name = "success", location = "/WEB-INF/views/center_msgboard.jsp") })
	public String msgBoard(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		msgBoards=msgCategoryService.findByUser(user);
		return SUCCESS;
	}
	@Action(value = "/saveMsgBoard", results = { @Result(name = "success", location = "/WEB-INF/views/center_msgboard.jsp") })
	public String saveMsgBoard(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		msgBoard.setUser(user);
		msgBoard.setCreateDate(new Date(System.currentTimeMillis()));
		msgCategoryService.save(msgBoard);
		msgBoards=msgCategoryService.findByUser(user);
		return SUCCESS;
	}
	@Action(value = "/deleteMsgBoard", results = { @Result(name = "success", type="redirect" , location = "centerMsgBoard") })
	public String deleteMsgBoard(){
		msgCategoryService.delete(msgBoard);
		msgBoards=msgCategoryService.findByUser(user);
		return SUCCESS;
	}
	@Action(value = "/centerCollect", results = { @Result(name = "success", location = "/WEB-INF/views/center_collect.jsp") })
	public String centerCollect(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		cookBooks=cookBookService.findByUser(user);
		return SUCCESS;
	}
	@Action(value = "/centerInfo", results = { @Result(name = "success", location = "/WEB-INF/views/center_info.jsp") })
	public String centerInfo(){
		return SUCCESS;
	}
	@Action(value = "/resetUser", results = { @Result(name = "success", location = "/WEB-INF/views/center.jsp") })
	public String resetUser(){
		userService.save(user);
		ActionContext.getContext().getSession().put("user",userService.find(user.getId()));
		this.tip="用户信息修改成功！";
		return SUCCESS;
	}
	
	@Action(value = "/uploadCookBook", results = { @Result(name = "success", location = "/WEB-INF/views/upload_cookbook.jsp") })
	public String uploadCookBook(){
		return SUCCESS;
	}
	@Action(value = "/douploadCookBook", results = { @Result(name = "success", location = "/WEB-INF/views/upload_cookbook.jsp") })
	public String douploadCookBook() throws IOException{
		cookBook.setCreateDate(new Date(System.currentTimeMillis()));
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		cookBook.setUser(user);
		List<CookFood> cookFoodsToSave= new ArrayList<CookFood>();
		if(cookFoods!=null){
			for(int i=0;i<cookFoods.size();i++){
				if(StringUtils.hasText(cookFoods.get(i).getName()) ){
					CookFood bean=new CookFood();
					bean.setName(cookFoods.get(i).getName());
					bean.setNumber(cookFoods.get(i).getNumber());
					bean.setCookBook(cookBook);
					cookFoodsToSave.add(bean);
				}
			}
		}
		cookBook.setCookFoods(cookFoodsToSave);
		
		List<CookStep> cookStepsToSave= new ArrayList<CookStep>();
		if(cookSteps!=null){
			for(int i=0;i<cookSteps.size();i++){
				if(StringUtils.hasText(cookSteps.get(i).getName()) ){
					CookStep bean=new CookStep();
					bean.setName(cookSteps.get(i).getName());
					if(stepImgFileName!=null&&stepImgFileName.length>i)
					bean.setImgPath(stepImgFileName[i]);
					bean.setCookBook(cookBook);
					cookStepsToSave.add(bean);
				}
			}
		}
		cookBook.setCookSteps(cookStepsToSave);
		cookBook.setImgPath(this.cookImgFileName);
		cookBookService.save(cookBook);
		/**文件上传逻辑*/
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		File cookImgSave = new File(new File(realpath), this.cookImgFileName);
		FileUtils.copyFile(cookImg, cookImgSave);
        
		
		if (stepImg != null) {
            File savedir=new File(realpath);
            for(int i=0;i<stepImg.length;i++){
                File savefile = new File(savedir, stepImgFileName[i]);
                FileUtils.copyFile(stepImg[i], savefile);
            }
        }
		tip="上传成功";
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	public CookBook getCookBook() {
		return cookBook;
	}
	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}
    public File getCookImg() {
		return cookImg;
	}
	public void setCookImg(File cookImg) {
		this.cookImg = cookImg;
	}
	public String getCookImgContentType() {
		return cookImgContentType;
	}
	public void setCookImgContentType(String cookImgContentType) {
		this.cookImgContentType = cookImgContentType;
	}
	public String getCookImgFileName() {
		return cookImgFileName;
	}
	public void setCookImgFileName(String cookImgFileName) {
		this.cookImgFileName = cookImgFileName;
	}
	public File[] getStepImg() {
		return stepImg;
	}
	public void setStepImg(File[] stepImg) {
		this.stepImg = stepImg;
	}
	public String[] getStepImgContentType() {
		return stepImgContentType;
	}
	public void setStepImgContentType(String[] stepImgContentType) {
		this.stepImgContentType = stepImgContentType;
	}
	public String[] getStepImgFileName() {
		return stepImgFileName;
	}
	public void setStepImgFileName(String[] stepImgFileName) {
		this.stepImgFileName = stepImgFileName;
	}
	public List<CookFood> getCookFoods() {
		return cookFoods;
	}
	public void setCookFoods(List<CookFood> cookFoods) {
		this.cookFoods = cookFoods;
	}
	public List<CookStep> getCookSteps() {
		return cookSteps;
	}
	public void setCookSteps(List<CookStep> cookSteps) {
		this.cookSteps = cookSteps;
	}
	public List<CookBook> getCookBooks() {
		return cookBooks;
	}
	public void setCookBooks(List<CookBook> cookBooks) {
		this.cookBooks = cookBooks;
	}
	public MsgBoard getMsgBoard() {
		return msgBoard;
	}
	public void setMsgBoard(MsgBoard msgBoard) {
		this.msgBoard = msgBoard;
	}
	public List<MsgBoard> getMsgBoards() {
		return msgBoards;
	}
	public void setMsgBoards(List<MsgBoard> msgBoards) {
		this.msgBoards = msgBoards;
	}
}

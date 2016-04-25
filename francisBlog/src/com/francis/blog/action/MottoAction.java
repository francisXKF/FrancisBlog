package com.francis.blog.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.pojo.Motto;
import com.francis.blog.service.MottoManager;
import com.opensymphony.xwork2.ActionSupport;

@Component("motto")
@Scope("prototype")
public class MottoAction extends ActionSupport{
	private Integer id;
	private String name;
	private Timestamp post_date;
	
	private MottoManager mottoManager;
	private String result;
	private Date now_date;
	private Motto motto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getPost_date() {
		return post_date;
	}
	public void setPost_date(Timestamp post_date) {
		this.post_date = post_date;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Resource
	public void setMottoManager(MottoManager mottoManager) {
		this.mottoManager = mottoManager;
	}
	
	public String insert() throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		String errorMsg = "";
		
		now_date = new Date();
		post_date = new java.sql.Timestamp(now_date.getTime());
		motto = new Motto();
		motto.setName(name);
		motto.setPost_date(post_date);
		mottoManager.insert(motto);
		return SUCCESS;
	}
	public String delete() throws Exception{
		motto = new Motto();
		motto.setId(id);
		mottoManager.delete(motto);
		return SUCCESS;
	}
	public String query() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		motto = new Motto();
		motto.setId(id);
		Motto queryMotto = mottoManager.query(motto);
		session.setAttribute("motto", queryMotto);
		return SUCCESS;
	}
}

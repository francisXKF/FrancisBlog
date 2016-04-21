package com.francis.blog.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.pojo.User;
import com.francis.blog.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport{
	private String name;
	private String email;
	private String linkURL;
	private String password;
	private String result;
	
	private User user;
	
	public String getResult() {
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkURL() {
		return linkURL;
	}

	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String insert() throws Exception {
		user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setLinkURL(linkURL);
		user.setPassword(password);
		Map<String, String> map = new HashMap<String, String>();
		if(userManager.insert(user) == true){
			map.put("status", "success");
			JSONObject jsonObject = JSONObject.fromObject(map);
			this.result = jsonObject.toString();
			return SUCCESS;
		}
		map.put("status", "failed");
		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonObject.toString();
		return ERROR;
	}
	
	public String login() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		user = new User();
		user.setName(name);
		user.setPassword(password);
		User login_user = userManager.exist(user);
		if(login_user == null){
			map.put("status", "failed");
			JSONObject jsonObject = JSONObject.fromObject(map);
			this.result = jsonObject.toString();
			return SUCCESS;  //无论是否存在，传递status，交由ajax来处理
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("login_user", login_user);
//		map.put("selfsession", session);
		map.put("status", "success");
		map.put("username", login_user.getName());
		map.put("userid", login_user.getId());
		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonObject.toString();
		return SUCCESS;
	}
	public String logout() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("login_user", null);
		map.put("status", "success");
		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonObject.toString();
		return SUCCESS;		
	}
	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return SUCCESS;
	}
}

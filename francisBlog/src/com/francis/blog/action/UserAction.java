package com.francis.blog.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.pojo.User;
import com.francis.blog.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport{
	private String name;
	private String email;
	private String linkURL;
	private String password; 
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

	private UserManager UserManager;
	
	public UserManager getUserManager() {
		return UserManager;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		UserManager = userManager;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(name);
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setLinkURL(linkURL);
		user.setPassword(password);
		System.out.println(user.getName());
		if(UserManager.insert(user) == true)
			return SUCCESS;
		return ERROR;
	}

	
}

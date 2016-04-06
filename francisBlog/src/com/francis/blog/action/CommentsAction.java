package com.francis.blog.action;

import com.francis.blog.service.CommentsManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentsAction extends ActionSupport{
	private String username;
	private String useremail;
	private String userurl;
	private String content;
	private CommentsManager commentsManager;
	
	public CommentsManager getCommentsManager() {
		return commentsManager;
	}
	public void setCommentsManager(CommentsManager commentsManager) {
		this.commentsManager = commentsManager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserurl() {
		return userurl;
	}
	public void setUserurl(String userurl) {
		this.userurl = userurl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String execute() throws Exception {
		//if(commentsManager.insert(comments))
		//	return SUCCESS;
		return ERROR;
	}

}

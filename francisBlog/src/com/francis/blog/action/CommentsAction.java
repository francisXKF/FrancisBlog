package com.francis.blog.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.pojo.Article;
import com.francis.blog.pojo.Comments;
import com.francis.blog.pojo.User;
import com.francis.blog.service.CommentsManager;
import com.francis.blog.util.GetClassFieldName;
import com.francis.blog.util.ObjectJsonValueProcessor;
import com.francis.blog.util.ObjectJsonValueProcessor4Comments;
import com.francis.blog.util.QueryConstent;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("comments")
@Scope("prototype")
public class CommentsAction extends ActionSupport{
	private Integer id;
	private String content;
	private Integer article_id;
	private Integer replycomment_id;
	private Timestamp comment_date;
	
	private Date now_date;
	private String username;
	private String useremail;
	private String userurl;
	
	private User user;
	private Article article;
	private Comments comments;
	private String result;
	
	private CommentsManager commentsManager;
	
	public CommentsManager getCommentsManager() {
		return commentsManager;
	}
	@Resource
	public void setCommentsManager(CommentsManager commentsManager) {
		this.commentsManager = commentsManager;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getReplycomment_id() {
		return replycomment_id;
	}
	public void setReplycomment_id(Integer replycomment_id) {
		this.replycomment_id = replycomment_id;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String insert() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		
		user = new User();
		article = new Article();
		comments = new Comments();
		now_date = new Date();
		
		comment_date = new java.sql.Timestamp(now_date.getTime());
		
		user.setName(username);
		user.setEmail(useremail);
		user.setLinkURL(userurl);
		user.setIdentity(QueryConstent.VISITOR);
		article.setId(article_id);
		comments.setArticle(article);
		comments.setComment_date(comment_date);
		comments.setContent(content);
		comments.setReplycomment_id(replycomment_id);
		comments.setUser(user);
		if(commentsManager.insert(comments) == true){
			map.put("status", "success");
			JSONObject jsonObject = JSONObject.fromObject(map);
			this.result = jsonObject.toString();
			System.out.println(comments.getReplycomment_id());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String queryByArticleId() throws Exception{

		article = new Article();
		comments = new Comments();
		
		article.setId(article_id);
		comments.setArticle(article);
		List<Comments> commentsList = commentsManager.query(comments);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Comments.class, 
				new ObjectJsonValueProcessor4Comments(new GetClassFieldName().getFieldName(comments), Comments.class));
		JSONArray jsonArray = JSONArray.fromObject(commentsList, jsonConfig);
		this.result = jsonArray.toString();
		return SUCCESS;
	}
	public String queryByTime() throws Exception{
		List<Map<String, Object>> commentsList = commentsManager.queryByTime(comment_date);
		JsonConfig jsonConfig = new JsonConfig();
		JSONArray jsonArray = JSONArray.fromObject(commentsList, jsonConfig);
		this.result = jsonArray.toString();
//		System.out.println(result);
		return SUCCESS;
	}
}

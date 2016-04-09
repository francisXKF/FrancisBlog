package com.francis.blog.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.francis.blog.pojo.Article;
import com.francis.blog.pojo.ArticleType;
import com.francis.blog.pojo.TagsType;
import com.francis.blog.pojo.User;
import com.francis.blog.service.ArticleManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("article")
@Scope("prototype")
public class ArticleAction extends ActionSupport{
	private String title;
	private String content;
	private Integer state;
	private Integer allow_comments;
	private Timestamp post_date;
	private String article_type_name;
	private String tags_typeString;
	
	private Date now_date;
	private ArticleManager articleManager;
	private String result;
	private Article article;
	private ArticleType articleType;
	private Set<TagsType> tagsType;
	private String[] tags_typeList;
	private User user;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getAllow_comments() {
		return allow_comments;
	}
	public void setAllow_comments(Integer allow_comments) {
		this.allow_comments = allow_comments;
	}
	public String getArticle_type_name() {
		return article_type_name;
	}
	public void setArticle_type_name(String article_type_name) {
		this.article_type_name = article_type_name;
	}
	public String getTags_typeString() {
		return tags_typeString;
	}
	public void setTags_typeString(String tags_typeString) {
		this.tags_typeString = tags_typeString;
	}
	
	public ArticleManager getArticleManager() {
		return articleManager;
	}
	
	@Resource
	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String insert() throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		user = new User(); // 改为由session拿到user
		article = new Article();
		articleType = new ArticleType();
		tagsType = new HashSet<TagsType>();
		now_date = new Date();
		post_date = new java.sql.Timestamp(now_date.getTime());
		
		articleType.setName(article_type_name); //有session可以删除
		tags_typeList = tags_typeString.split(",");
		int length = tags_typeList.length;
		TagsType tagsTypeSingle;
		for(int i = 0; i < length; i++){
			tagsTypeSingle = new TagsType();
			tagsTypeSingle.setName(tags_typeList[i]);
			tagsType.add(tagsTypeSingle);
		}
		
		user.setName("francis23");  //有session可以删除
		
		article.setUser(user);
		article.setTitle(title);
		article.setState(state);
		article.setContent(content);
		article.setAllow_comments(allow_comments);
		article.setPost_date(post_date);
		article.setArticleType(articleType);
		article.setTagsType(tagsType);
		System.out.println(article.getArticleType().getName());
		if(articleManager.insert(article) == true){
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
}
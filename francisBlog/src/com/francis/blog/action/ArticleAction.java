package com.francis.blog.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.francis.blog.pojo.Article;
import com.francis.blog.service.ArticleManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("article")
@Scope("prototype")
public class ArticleAction extends ActionSupport implements ModelDriven<Article>{
	private Article article = new Article();
	private ArticleManager articleManager;
	private String result;

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
		System.out.println(article.getContent());
		System.out.println(article.getAllow_comments());
		System.out.println(article.getArticleType());
		System.out.println(article.getTitle());
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
	
	@Override
	public Article getModel() {
		return article;
	}

}

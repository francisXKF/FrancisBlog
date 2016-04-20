package com.francis.blog.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.pojo.ArticleType;
import com.francis.blog.service.ArticleTypeManager;
import com.opensymphony.xwork2.ActionSupport;

@Component("articleType")
@Scope("prototype")
public class ArticleTypeAction extends ActionSupport{
	
	private String result;
	private ArticleType articleType;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private ArticleTypeManager articleTypeManager;
	
	@Resource
	public void setArticleTypeManager(ArticleTypeManager articleTypeManager) {
		this.articleTypeManager = articleTypeManager;
	}

	public String query() throws Exception{
		articleType = new ArticleType();
		List<Map<String, Object>> articleTypeList = articleTypeManager.query(articleType);
		JsonConfig jsonConfig = new JsonConfig();
		JSONArray jsonArray = JSONArray.fromObject(articleTypeList, jsonConfig);
		this.result = jsonArray.toString();
		return SUCCESS;
	}
}

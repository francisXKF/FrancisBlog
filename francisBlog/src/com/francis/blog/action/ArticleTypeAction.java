package com.francis.blog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.pojo.ArticleType;
import com.francis.blog.service.ArticleTypeManager;
import com.opensymphony.xwork2.ActionSupport;

@Component("articleType")
@Scope("prototype")
public class ArticleTypeAction extends ActionSupport{
	private Integer id;
	private String name;
	
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
	public String update() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		articleType = new ArticleType();
		articleType.setId(id);
		articleType.setName(name);
		if(articleTypeManager.update(articleType)){
			map.put("status", "success");
		}
		else{
			map.put("status", "failed");
		}
		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonObject.toString();
		return SUCCESS;
	}
}

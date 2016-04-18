package com.francis.blog.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.francis.blog.pojo.Article;
import com.francis.blog.pojo.ArticleType;
import com.francis.blog.pojo.TagsType;
import com.francis.blog.pojo.User;
import com.francis.blog.service.ArticleManager;
import com.francis.blog.util.GetClassFieldName;
import com.francis.blog.util.ObjectJsonValueProcessor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("article")
@Scope("prototype")
public class ArticleAction extends ActionSupport{
	private Integer id;
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		user = (User)session.getAttribute("login_user"); //由session获取当前用户
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
		
		article.setUser(user);
		article.setTitle(title);
		article.setState(state);
		article.setContent(content);
		article.setAllow_comments(allow_comments);
		article.setPost_date(post_date);
		article.setArticleType(articleType);
		article.setTagsType(tagsType);
		
		if(articleManager.insert(article) == true){
			map.put("status", "success");
			JSONObject jsonObject = JSONObject.fromObject(map);
			this.result = jsonObject.toString();
			return SUCCESS;
		}
		map.put("status", "failed");
		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonObject.toString();
		return SUCCESS; //由ajax来处理failed
	}
	public String query() throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		article = new Article();
		articleType = new ArticleType();
		tagsType = new HashSet<TagsType>();
		
		articleType.setName(article_type_name);
		tags_typeList = tags_typeString.split(",");
		int length = tags_typeList.length;
		TagsType tagsTypeSingle;
		for(int i = 0; i < length; i++){
			tagsTypeSingle = new TagsType();
			tagsTypeSingle.setName(tags_typeList[i]);
			tagsType.add(tagsTypeSingle);
		}
		
		article.setArticleType(articleType);
		article.setTagsType(tagsType);
		
		List<Article> articleList = articleManager.query(article);
		map.put("articleList", articleList);
		map.put("status", "success");
		/*该方法可能只解决obj的时候，若用list，需要另一种解决。
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object obj, String name, Object value) {
				return (obj instanceof Article && name.equals("article")) || value==null;
			}
		});
		*/
		/*可用，但会过滤掉所有关联对象
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object arg0, String arg1, Object arg2) {
            	 something is wrong
            	if(arg0 instanceof ArticleType && arg1.equals("article") || arg2 == null){
            		return true;
            	}
            	if(arg0 instanceof TagsType && arg1.equals("article") || arg2 == null){
            		return true;
            	}
            	if(arg0 instanceof User && arg1.equals("article") || arg2 == null){
            		return true;
            	}
                if (arg1.equals("articleType")
                		|| arg1.equals("tagsType") || arg1.equals("user")){
                	return true;
                }
            	return false;
            }
        });
        */
		/*并未能解决死循环问题
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				if(arg1.equals("article")){
					return true;
				}
				return false;
			}
		});
		*/
		/*
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false); //设置默认忽略 
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);//设置循环策略为忽略    解决json最头疼的问题 死循环
		jsonConfig.setExcludes(new String[] {"article"});
		*/
		
		/*该方法只能用于list对象*/
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Article.class, 
				new ObjectJsonValueProcessor(new GetClassFieldName().getFieldName(article), Article.class));
		JSONArray jsonArray = JSONArray.fromObject(articleList, jsonConfig);
//		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonArray.toString();
		return SUCCESS;
	}
	
	public String queryById() throws Exception{
		article = articleManager.queryById(id);
		System.out.println("query ok");
		List<Article> articleList = new ArrayList<Article>();
		articleList.add(article);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Article.class, 
				new ObjectJsonValueProcessor(new GetClassFieldName().getFieldName(article), Article.class));
		JSONArray jsonArray = JSONArray.fromObject(articleList, jsonConfig);
//		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonArray.toString();
		return SUCCESS;
	}
}
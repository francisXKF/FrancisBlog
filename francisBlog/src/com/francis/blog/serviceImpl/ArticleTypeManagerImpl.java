package com.francis.blog.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleTypeDao;
import com.francis.blog.pojo.ArticleType;
import com.francis.blog.service.ArticleTypeManager;

@Component("articleTypeManager")
public class ArticleTypeManagerImpl implements ArticleTypeManager{
	
	private ArticleTypeDao articleTypeDao;
	
	@Resource
	public void setArticleTypeDao(ArticleTypeDao articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}
	
	@Override
	public List<Map<String, Object>> query(ArticleType articleType) {
		return articleTypeDao.query(articleType);
	}
	
	@Override
	public boolean update(ArticleType articleType){
		return articleTypeDao.update(articleType);
	}

}

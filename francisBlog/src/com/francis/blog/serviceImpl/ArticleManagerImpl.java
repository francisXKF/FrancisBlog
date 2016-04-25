package com.francis.blog.serviceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleDao;
import com.francis.blog.dao.ArticleTypeDao;
import com.francis.blog.dao.TagsTypeDao;
import com.francis.blog.dao.UserDao;
import com.francis.blog.pojo.Article;
import com.francis.blog.pojo.ArticleType;
import com.francis.blog.pojo.TagsType;
import com.francis.blog.service.ArticleManager;

@Component("articleManager")
public class ArticleManagerImpl implements ArticleManager{

	private ArticleDao articleDao;
	private ArticleTypeDao articleTypeDao;
	private TagsTypeDao tagsTypeDao;
	private UserDao userDao;
	
	@Resource
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	@Resource
	public void setArticleTypeDao(ArticleTypeDao articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}
	@Resource
	public void setTagsTypeDao(TagsTypeDao tagsTypeDao) {
		this.tagsTypeDao = tagsTypeDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<Article> query(Article article, Integer start) {
		return articleDao.query(article, start);
	}

	@Override
	public Article queryById(Integer id) {
		return articleDao.queryById(id);
	}
	
	@Override
	public Integer querySize(Article article) {
		return articleDao.querySize(article);
	}
	@Override
	public boolean update(Article article) {
		if(articleTypeDao.queryByName(article.getArticleType().getName()) == null){
			articleTypeDao.insert(article.getArticleType());
		}
		article.setArticleType(articleTypeDao.queryByName(article.getArticleType().getName()));
		Set<TagsType> tagsTypes = article.getTagsType();
		Set<TagsType> tagsTypesQueryed = new HashSet<TagsType>();
		TagsType tagsType;
		Iterator<TagsType> it = tagsTypes.iterator();
		while(it.hasNext()){
			tagsType = it.next();
			if(tagsTypeDao.queryByName(tagsType.getName()) == null){
				tagsTypeDao.insert(tagsType);
			}
			tagsTypesQueryed.add(tagsTypeDao.queryByName(tagsType.getName()));
		}
		article.setTagsType(tagsTypesQueryed);
		return articleDao.update(article);
	}

	@Override
	public boolean delete(Article article) {
		return articleDao.delete(article);
	}

	@Override
	public boolean insert(Article article) {
		if(userDao.queryByName(article.getUser().getName()) == null){
			return false;
		}
		else{  //如果有session这个可以删除
			article.setUser(userDao.queryByName(article.getUser().getName()));
		}
		if(articleTypeDao.queryByName(article.getArticleType().getName()) == null){
			articleTypeDao.insert(article.getArticleType());
		}
		article.setArticleType(articleTypeDao.queryByName(article.getArticleType().getName()));
		Set<TagsType> tagsTypes = article.getTagsType();
		Set<TagsType> tagsTypesQueryed = new HashSet<TagsType>();
		TagsType tagsType;
		Iterator<TagsType> it = tagsTypes.iterator();
		while(it.hasNext()){
			tagsType = it.next();
			if(tagsTypeDao.queryByName(tagsType.getName()) == null){
				tagsTypeDao.insert(tagsType);
			}
			tagsTypesQueryed.add(tagsTypeDao.queryByName(tagsType.getName()));
		}
		article.setTagsType(tagsTypesQueryed);
		articleDao.insert(article);
		return true;
	}

}

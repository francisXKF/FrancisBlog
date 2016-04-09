package com.francis.blog.serviceImpl;

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
	public List<Article> query(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Article article) {
		// TODO Auto-generated method stub
		return false;
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

		Set<TagsType> tagsTypes = article.getTagsType();
		TagsType tagsType;
		Iterator<TagsType> it = tagsTypes.iterator();
		while(it.hasNext()){
			tagsType = it.next();
			if(tagsTypeDao.queryByName(tagsType.getName()) == null){
				tagsTypeDao.insert(tagsType);
			}
		}
		articleDao.insert(article);
		return true;
	}

}
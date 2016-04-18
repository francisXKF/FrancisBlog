package com.francis.blog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleDao;
import com.francis.blog.dao.CommentsDao;
import com.francis.blog.dao.UserDao;
import com.francis.blog.pojo.Article;
import com.francis.blog.pojo.Comments;
import com.francis.blog.service.CommentsManager;

@Component("commentsManager")
public class CommentsManagerImpl implements CommentsManager{

	private ArticleDao articleDao;
	private UserDao userDao;
	private CommentsDao commentsDao;
	
	@Resource
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Resource
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	
	@Override
	public boolean insert(Comments comments) {
		if(userDao.queryByName(comments.getUser().getName()) == null){
			userDao.insert(comments.getUser());
		}
		comments.setUser(userDao.queryByName(comments.getUser().getName()));
		Article article = articleDao.queryById(comments.getArticle().getId());
		if(article == null){
			return false;
		}
		comments.setArticle(article);
		return commentsDao.insert(comments);
	}

	@Override
	public List<Comments> query(Comments comments) {
		return commentsDao.query(comments);
	}

}

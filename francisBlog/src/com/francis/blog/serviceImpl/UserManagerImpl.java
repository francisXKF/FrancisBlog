package com.francis.blog.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleDao;
import com.francis.blog.dao.CommentsDao;
import com.francis.blog.dao.UserDao;
import com.francis.blog.pojo.Article;
import com.francis.blog.pojo.Comments;
import com.francis.blog.pojo.User;
import com.francis.blog.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager{

	private UserDao userDao;
	private CommentsDao commentsDao;
	private ArticleDao articleDao;
	
	@Resource
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	
	@Resource
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Map<String, Object>> query() {
		return userDao.query();
	}

	@Override
	public User exist(User user) {
		return userDao.queryExist(user);
	}
	@Override
	public User queryById(Integer id) {
		Map<String, Object> userMap = userDao.queryById(id);
		User user = new User();
		user.setId((Integer)userMap.get("id"));
		user.setName((String)userMap.get("name"));
		user.setEmail((String)userMap.get("email"));
		user.setLinkURL((String)userMap.get("linkURL"));
		user.setIdentity((Integer)userMap.get("identity"));
		return user;
	}
	@Override
	public User queryByName(String name) {
		return userDao.queryByName(name);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean delete(User user) {
		Comments comments = commentsDao.queryByUserId(user.getId());
		if(comments != null)
			commentsDao.delete(comments);
		System.out.println("comments delete");
		Article article = articleDao.queryByUserId(user.getId());
		if(article != null)
			articleDao.delete(article);
		System.out.println("article delete");
		if(userDao.queryById(user.getId()) != null)
			userDao.delete(user);
		System.out.println("delete all");
		return true;
	}

	@Override
	public boolean insert(User user) {
		return userDao.insert(user);
	}
}

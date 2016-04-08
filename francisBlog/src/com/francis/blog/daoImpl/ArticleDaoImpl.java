package com.francis.blog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleDao;
import com.francis.blog.pojo.Article;

@Component("articleDao")
@Scope("prototype")
public class ArticleDaoImpl implements ArticleDao{

	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
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
		currentSession().save(article);
		return true;
	}

}

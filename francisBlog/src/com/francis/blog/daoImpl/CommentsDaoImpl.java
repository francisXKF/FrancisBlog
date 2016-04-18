package com.francis.blog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.CommentsDao;
import com.francis.blog.pojo.Comments;

@Component("commentsDao")
@Scope("prototype")
public class CommentsDaoImpl implements CommentsDao{
	private SessionFactory sessionFactory;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Comments> query(Comments comments) {
		String sqlString = "from Comments cmt where cmt.article.id="+comments.getArticle().getId()
							+" order by cmt.comment_date desc";
		List<Comments> commentsList = currentSession().createQuery(sqlString).list();
		return commentsList;
	}

	@Override
	public boolean update(Comments comments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comments comments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Comments comments) {
		currentSession().save(comments);
		return true;
	}

}

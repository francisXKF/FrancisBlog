package com.francis.blog.daoImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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
							+" order by cmt.comment_date";
		List<Comments> commentsList = currentSession().createQuery(sqlString).list();
		return commentsList;
	}
	
	@Override
	public List<Map<String, Object>> queryByTime(Timestamp timestamp) {
		String sqlString = "select user.name as username, art.id as article_id, "+
							"art.title as article_title, cmt.comment_date as comment_date "+
							"from (Comments cmt left join Article art on cmt.article_id = art.id)"+
							" left join User user on cmt.user_id = user.id";
//		System.out.println(sqlString);
		List<Map<String, Object>> queryList= currentSession().createSQLQuery(sqlString).list();
		return queryList;
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

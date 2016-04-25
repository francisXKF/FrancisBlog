package com.francis.blog.daoImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleTypeDao;
import com.francis.blog.pojo.ArticleType;

@Component("articleTypeDao")
@Scope("prototype")
public class ArticleTypeDaoImpl implements ArticleTypeDao{
	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Map<String, Object>> query(ArticleType articleType) {
		String sqlString = "select artt.id as ID, artt.name as Name from ArticleType artt order by artt.name";
		List<Map<String, Object>> articleTypeList = currentSession().createSQLQuery(sqlString)
													.list();
		return articleTypeList;
	}

	@Override
	public ArticleType queryByName(String name) {
		String sqlString = "from ArticleType where name=?";
		List<ArticleType> articleTypes = currentSession().createQuery(sqlString)
										.setParameter(0, name).list();
		if(articleTypes.isEmpty()){
			return null;
		}
		return (ArticleType)articleTypes.get(0);
	}

	@Override
	public boolean update(ArticleType articleType) {
		currentSession().update(articleType);
		return true;
	}

	@Override
	public boolean delete(ArticleType articleType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(ArticleType articleType) {
		currentSession().save(articleType);
		return true;
	}

}

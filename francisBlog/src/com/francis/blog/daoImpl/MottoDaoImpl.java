package com.francis.blog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.MottoDao;
import com.francis.blog.pojo.Motto;

@Component("mottoDao")
@Scope("prototype")
public class MottoDaoImpl implements MottoDao{

	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Motto> query(Motto motto) {
		String sqlString = "from Motto order by post_date desc";
		List<Motto> mottoList = currentSession().createQuery(sqlString).list();
		return mottoList;
	}

	@Override
	public boolean delete(Motto motto) {
		currentSession().delete(motto);
		return true;
	}

	@Override
	public boolean insert(Motto motto) {
		currentSession().save(motto);
		return true;
	}

}

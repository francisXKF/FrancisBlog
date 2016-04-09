package com.francis.blog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.UserDao;
import com.francis.blog.pojo.User;

@Component("userDao")
@Scope("prototype")
public class UserDaoImpl implements UserDao{
//	private HibernateTemplate hibernateTemplate;
//	
//	public HibernateTemplate getHibernateTemplate() {
//		return hibernateTemplate;
//	}
//	
//	@Resource
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}

	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<User> query(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		System.out.println("enter");
//		this.hibernateTemplate.save(user);
		currentSession().save(user);
		System.out.println("add user ok");
		return true;
	}

}

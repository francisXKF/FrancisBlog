package com.francis.blog.daoImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.transform.Transformers;
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
	public List<Map<String, Object>> query() {
		String sqlString = "select id, name, email, linkURL, identity from User";
		List<Map<String, Object>> userList = currentSession().createSQLQuery(sqlString)
							.list();
		return userList;
	}

	@Override
	public User queryExist(User user) {
		String sqlString = "from User where name=? and password=?";
		List<User> userList = currentSession().createQuery(sqlString)
							.setParameter(0, user.getName())
							.setParameter(1, user.getPassword())
							.list();
		if(userList.isEmpty()){
			return null;
		}
		return userList.get(0);
	}
	
	@Override
	public User queryByName(String name) {
		String sqlString = "select id, name, email, linkURL, identity from User where name='" + name + "'";
		List<Map<String, Object>> userList = currentSession().createSQLQuery(sqlString)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		
		if(userList.isEmpty()){
			return null;
		}
		
		Map<String, Object> userMap = userList.get(0);
		User user = new User();
		user.setId((Integer)userMap.get("id"));
		user.setName((String)userMap.get("name"));
		user.setEmail((String)userMap.get("email"));
		user.setLinkURL((String)userMap.get("linkURL"));
		
		return user;
	}

	@Override
	public Map<String, Object> queryById(Integer id) {
		String sqlString = "select id, name, email, linkURL, identity from User where id=" + id;
		List<Map<String, Object>> userList = currentSession().createSQLQuery(sqlString)
							.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		if(userList.isEmpty()){
			return null;
		}
		return userList.get(0);
	}
	
	@Override
	public boolean update(User user) {
		currentSession().update(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		currentSession().delete(user);
		return true;
	}

	@Override
	public boolean insert(User user) {
//		this.hibernateTemplate.save(user);
		currentSession().save(user);
		return true;
	}

}

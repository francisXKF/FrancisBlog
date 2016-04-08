package com.francis.blog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.TagsTypeDao;
import com.francis.blog.pojo.TagsType;

@Component("tagsTypeDao")
@Scope("prototype")
public class TagsTypeDaoImpl implements TagsTypeDao{
	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public TagsType queryByName(String name) {
		String sqlString = "from tagstype where name=?";
		List<TagsType> tagsTypes = currentSession().createQuery(sqlString)
									.setParameter(0, name).list();
		if(tagsTypes.isEmpty()){
			return null;
		}
		return tagsTypes.get(0);
	}

	@Override
	public boolean insert(TagsType tagsType) {
		currentSession().save(tagsType);
		return true;
	}

}

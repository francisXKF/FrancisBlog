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
		String sqlString = "from TagsType where name=?";
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

	@Override
	public List<String> queryByArticleId(Integer id) {
		/*String sqlString = "select tags.name as name "
				+ "(from TagsType tags left join article_tagstype art_tags on tags.id=art_tags.tagstype_id) "
				+ "left join Article art on art.id=art_tags.article_id where art.id=" + id;*/
		String sqlString = "select tags.name as name "
				+ "from TagsType tags left join tags.article art "
				+ "where art.id=" + id
				+ " order by name desc";
		List<String> tagsnameList = currentSession().createQuery(sqlString).list();
		return tagsnameList;
	}

}

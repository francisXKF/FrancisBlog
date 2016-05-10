package com.francis.blog.daoImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.ArticleDao;
import com.francis.blog.pojo.Article;
import com.francis.blog.util.QueryConstent;

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
	public List<Article> query(Article article, Integer start) {
		String sqlString = "from Article art where art.articleType.name like ? order by post_date desc";
		//sqlString += " limit " + start + ", " + "10";  //固定十个一组
//		System.out.println(start + "   " + (start + QueryConstent.STEP));
		List<Article> articleList = currentSession().createQuery(sqlString)
								.setParameter(0, article.getArticleType().getName())
								.setFirstResult(start).setMaxResults(QueryConstent.STEP)
								.list();
		return articleList;
	}

	@Override
	public Article queryById(Integer id) {
		String sqlString = "from Article art where art.id="+id;
		List<Article> articleList = currentSession().createQuery(sqlString)
									.list();
		if(articleList.isEmpty()){
			return null;
		}
		return articleList.get(0);
	}

	@Override
	public Map<String, Object> queryByIdDetail(Integer id) {
		String sqlString = "select art.id as id, art.title as title, art.post_date as post_date, "
				+ "art.content as content, artt.name as arttname, user.name as username "
				+ "from (Article art left join ArticleType artt on art.articleType_id = artt.id) "
				+ "left join User user on art.user_id = user.id "
				+ "where art.id="+id;
		List<Map<String, Object>> articleList = currentSession().createSQLQuery(sqlString)
									.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
									.list();
		if(articleList.isEmpty()){
			return null;
		}
		return articleList.get(0);
	}
	
	@Override
	public Article queryByUserId(Integer user_id) {
		String sqlString = "from Article art where art.user.id=" + user_id;
		List<Article> articleList = currentSession().createQuery(sqlString).list();
		if(articleList.isEmpty())
			return null;
		return articleList.get(0);
	}
	
	@Override
	public Integer querySize(Article article) {
		String sqlString = "select count(art.id) from "
				+ "Article art left join ArticleType artt on art.articleType_id = artt.id "
				+ "where artt.name like ?";
		Integer length = (new Integer(currentSession().createSQLQuery(sqlString)
							.setParameter(0, article.getArticleType().getName())
							.uniqueResult().toString())).intValue();
		return length;
	}
	@Override
	public boolean update(Article article) {
		currentSession().update(article);
		return true;
	}

	@Override
	public boolean delete(Article article) {
		currentSession().delete(article);
		return true;
	}

	@Override
	public boolean insert(Article article) {
		currentSession().save(article);
		return true;
	}

}

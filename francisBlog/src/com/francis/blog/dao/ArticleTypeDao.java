package com.francis.blog.dao;

import java.util.List;
import java.util.Map;

import com.francis.blog.pojo.ArticleType;

public interface ArticleTypeDao {
	public List<Map<String, Object>> query(ArticleType articleType);
	public ArticleType queryByName(String name);
	public boolean update(ArticleType articleType);
	public boolean delete(ArticleType articleType);
	public boolean insert(ArticleType articleType);
}

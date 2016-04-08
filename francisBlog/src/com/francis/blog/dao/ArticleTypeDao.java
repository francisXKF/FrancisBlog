package com.francis.blog.dao;

import java.util.List;

import com.francis.blog.pojo.ArticleType;

public interface ArticleTypeDao {
	public List<ArticleType> query(ArticleType articleType);
	public ArticleType queryByName(String name);
	public boolean update(ArticleType articleType);
	public boolean delete(ArticleType articleType);
	public boolean insert(ArticleType articleType);
}

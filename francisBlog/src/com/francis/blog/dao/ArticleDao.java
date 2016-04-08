package com.francis.blog.dao;

import java.util.List;

import com.francis.blog.pojo.Article;

public interface ArticleDao {
	public List<Article> query(Article article);
	public boolean update(Article article);
	public boolean delete(Article article);
	public boolean insert(Article article);
}

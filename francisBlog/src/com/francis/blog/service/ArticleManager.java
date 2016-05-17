package com.francis.blog.service;

import java.util.List;

import com.francis.blog.pojo.Article;

public interface ArticleManager {
	public List<Article> query(Article article, Integer start);
	public Integer querySize(Article article);
	public Article queryById(Integer id);
	public boolean update(Article article);
	public boolean delete(Article article);
	public boolean insert(Article article);
	public boolean saveAsWord(String content, String path) throws Exception;
}

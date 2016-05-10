package com.francis.blog.service;

import java.util.List;
import java.util.Map;

import com.francis.blog.pojo.ArticleType;

public interface ArticleTypeManager {
	public List<Map<String, Object>> query(ArticleType articleType);
	public boolean update(ArticleType articleType);
}

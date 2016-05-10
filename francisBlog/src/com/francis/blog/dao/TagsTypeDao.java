package com.francis.blog.dao;

import java.util.List;

import com.francis.blog.pojo.TagsType;

public interface TagsTypeDao {
	public TagsType queryByName(String name);
	public boolean insert(TagsType tagsType);
	public List<String> queryByArticleId(Integer id);
}

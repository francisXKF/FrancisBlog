package com.francis.blog.dao;

import com.francis.blog.pojo.TagsType;

public interface TagsTypeDao {
	public TagsType queryByName(String name);
	public boolean insert(TagsType tagsType);
}

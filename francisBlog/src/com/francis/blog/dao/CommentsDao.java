package com.francis.blog.dao;

import java.util.List;

import com.francis.blog.pojo.Comments;

public interface CommentsDao {
	public List<Comments> query(Comments comments);
	public boolean update(Comments comments);
	public boolean delete(Comments comments);
	public boolean insert(Comments comments);
}
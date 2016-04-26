package com.francis.blog.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.francis.blog.pojo.Comments;

public interface CommentsDao {
	public List<Comments> query(Comments comments);
	public List<Map<String, Object>> queryByTime(Timestamp timestamp);
	public Comments queryByUserId(Integer user_id);
	public boolean update(Comments comments);
	public boolean delete(Comments comments);
	public boolean insert(Comments comments);
}

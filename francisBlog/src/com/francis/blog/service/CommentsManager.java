package com.francis.blog.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.francis.blog.pojo.Comments;

public interface CommentsManager {
	public boolean insert(Comments comments);
	public List<Comments> query(Comments comments);
	public List<Map<String, Object>> queryByTime(Timestamp timestamp);
}

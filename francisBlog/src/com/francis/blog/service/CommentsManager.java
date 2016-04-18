package com.francis.blog.service;

import java.util.List;

import com.francis.blog.pojo.Comments;

public interface CommentsManager {
	public boolean insert(Comments comments);
	public List<Comments> query(Comments comments);
}

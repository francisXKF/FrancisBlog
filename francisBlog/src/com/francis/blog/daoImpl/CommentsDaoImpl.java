package com.francis.blog.daoImpl;

import java.util.List;

import com.francis.blog.dao.CommentsDao;
import com.francis.blog.pojo.Comments;

public class CommentsDaoImpl implements CommentsDao{

	@Override
	public List<Comments> query(Comments comments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Comments comments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comments comments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Comments comments) {
		// TODO Auto-generated method stub
		System.out.println("add comments ok");
		return true;
	}

}

package com.francis.blog.dao;

import java.util.List;

import com.francis.blog.pojo.Motto;

public interface MottoDao {
	public List<Motto> query(Motto motto);
	public boolean delete(Motto motto);
	public boolean insert(Motto motto);
}

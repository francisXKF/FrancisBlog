package com.francis.blog.dao;

import java.util.List;

import com.francis.blog.pojo.User;

public interface UserDao {
	public List<User> query(User user);
	public User queryByName(String name);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean insert(User user);
}

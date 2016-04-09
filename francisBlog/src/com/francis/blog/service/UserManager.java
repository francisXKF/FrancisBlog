package com.francis.blog.service;

import java.util.List;

import com.francis.blog.pojo.User;

public interface UserManager {
	public List<User> query(User user);
	public User exist(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean insert(User user);
}

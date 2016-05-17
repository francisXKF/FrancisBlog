package com.francis.blog.service;

import java.util.List;
import java.util.Map;

import com.francis.blog.pojo.User;

public interface UserManager {
	public List<Map<String, Object>> query();
	public User exist(User user);
	public User queryById(Integer id);
	public User queryByName(String name);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean insert(User user);
}

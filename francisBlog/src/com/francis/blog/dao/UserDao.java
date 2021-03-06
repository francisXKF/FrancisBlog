package com.francis.blog.dao;

import java.util.List;
import java.util.Map;

import com.francis.blog.pojo.User;

public interface UserDao {
	public List<Map<String, Object>> query();
	public User queryExist(User user);
	public User queryByName(String name);
	public Map<String, Object> queryById(Integer id);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean insert(User user);
}

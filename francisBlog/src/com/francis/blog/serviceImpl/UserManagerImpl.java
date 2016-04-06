package com.francis.blog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.francis.blog.dao.UserDao;
import com.francis.blog.pojo.User;
import com.francis.blog.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> query(User user) {
		return userDao.query(user);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean delete(User user) {
		return userDao.delete(user);
	}

	@Override
	public boolean insert(User user) {
		System.out.println(userDao==null);
		return userDao.insert(user);
	}
}

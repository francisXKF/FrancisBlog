package com.francis.blog.daoImpl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.francis.blog.dao.UserDao;
import com.francis.blog.pojo.User;

@Component("userDao")
@Scope("prototype")
public class UserDaoImpl implements UserDao{

	@Override
	public List<User> query(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		System.out.println("add user ok");
		return true;
	}

}

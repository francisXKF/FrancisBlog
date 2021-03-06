package com.francis.blog.service;

import java.util.List;

import com.francis.blog.pojo.Motto;

public interface MottoManager {
	public Motto query(Motto motto);
	public boolean delete(Motto motto);
	public boolean insert(Motto motto);
}

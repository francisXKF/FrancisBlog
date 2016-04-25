package com.francis.blog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.francis.blog.dao.MottoDao;
import com.francis.blog.pojo.Motto;
import com.francis.blog.service.MottoManager;

@Component("mottoManager")
public class MottoManagerImpl implements MottoManager{
	private MottoDao mottoDao;
	
	@Resource
	public void setMottoDao(MottoDao mottoDao) {
		this.mottoDao = mottoDao;
	}

	@Override
	public Motto query(Motto motto) {
		List<Motto> mottoList = mottoDao.query(motto);
		if(mottoList.isEmpty()){
			return null;
		}
		return mottoList.get(0);
	}

	@Override
	public boolean delete(Motto motto) {
		return mottoDao.delete(motto);
	}

	@Override
	public boolean insert(Motto motto) {
		return mottoDao.insert(motto);
	}

}

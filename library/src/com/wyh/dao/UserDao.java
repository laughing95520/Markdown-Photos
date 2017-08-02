package com.wyh.dao;

import java.util.List;

import com.duobang.orm.ORM;

public class UserDao {

	public boolean saveuser(String username, String password) {
		ORM orm = new ORM();
		try {
			return orm.executeDate("insert_sign", new Object[]{username,password});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	public boolean checkuser(String username, String password) throws Exception {
		ORM orm = new ORM();
		List<Object> queryDataEx = orm.queryDataEx("select_user",  new Object[]{username,password});
		return queryDataEx.size()==1;
		
		
	}
	
}

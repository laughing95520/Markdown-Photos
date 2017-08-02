package com.wyh.dao;


import java.util.LinkedList;
import java.util.List;

import com.duobang.orm.ORM;
import com.wyh.bean.ReaderBean;



public class ReaderDao {


	public boolean save(ReaderBean readerBean) {
		ORM orm = new ORM();
		try {
		//readername,age,sex,email,profession
		Object[] value={readerBean.getReadername(),readerBean.getAge(),readerBean.getSex(),readerBean.getEmail(),readerBean.getProfession()};
		return orm.executeDate("insert_reader", value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public List<ReaderBean> query() {
		ORM orm = new ORM();
		try {
			List<Object> list = orm.queryDataEx("select_reader");
			List<ReaderBean> rs = new LinkedList<ReaderBean>();
			for (Object valuelist : list) {
				rs.add((ReaderBean)(valuelist));
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public boolean delete(int id) {
		ORM orm = new ORM();
		try {
			Object[] value = {id};
			return orm.executeDate("delete_list_id",value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		
	}

	public List<ReaderBean> select(int reseiveid) {
		ORM orm = new ORM();
		try {
			Object[] value = {reseiveid};
			List<Object> list = orm.queryDataEx("id_select_reader",value);
			List<ReaderBean> rs = new LinkedList<ReaderBean>();
			for (Object valuelist : list) {
				rs.add((ReaderBean)(valuelist));
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public boolean update(ReaderBean readerBean) {
		ORM orm = new ORM();
		try {
		//readername,age,sex,email,profession
		Object[] value={readerBean.getReadername(),readerBean.getAge(),readerBean.getSex(),readerBean.getEmail(),readerBean.getProfession(),readerBean.getId()};
		return orm.executeDate("update_reader", value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	}

	

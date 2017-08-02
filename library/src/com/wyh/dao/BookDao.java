package com.wyh.dao;

import java.util.LinkedList;
import java.util.List;

import com.duobang.orm.ORM;
import com.wyh.bean.BookBean;

public class BookDao {
	ORM orm = new ORM();
	public boolean save(BookBean bean) {
		
		try {
		Object[] value = {bean.getSerialnum(),bean.getName(),
				bean.getPrice(),bean.getBookCount(),bean.getAuthor(),bean.getPress()};
		return orm.executeDate("save_book", value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	public List<BookBean> select(int choice, String value) {
		List<Object> templist = new LinkedList<Object>();
		List<BookBean> booklist = new LinkedList<BookBean>();
		Object[] values = {value};
		String sqlid = "";
		try{
		switch (choice) {
		case 0:
			sqlid="select_all";
			templist = orm.queryDataEx(sqlid);
			
			break;
		case 1:
			sqlid = "select_byname";
			templist = orm.queryDataEx(sqlid,values);
			break;
		case 2:
			sqlid = "select_byauthor";
			templist = orm.queryDataEx(sqlid,values);
			break;
		case 3:
			sqlid = "select_byid";
			int valuetemp = Integer.valueOf(value);
			templist = orm.queryDataEx(sqlid,valuetemp);
			break;
		default:
			break;
			}
		for (Object obj : templist) {
			booklist.add((BookBean)obj);
			}
			return booklist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	public boolean delete(int reseiveid) {
		try {
			Object[] value = {reseiveid};
			return orm.executeDate("delete_book_id",value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	public boolean update(BookBean bookBean) {
		try {
		
		Object[] value={bookBean.getSerialnum(),bookBean.getName(),bookBean.getPrice(),
				bookBean.getBookCount(),bookBean.getAuthor(),bookBean.getPress(),bookBean.getId()};
		return orm.executeDate("update_book", value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}

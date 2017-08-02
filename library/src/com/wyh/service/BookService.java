package com.wyh.service;

import java.util.List;

import com.wyh.bean.BookBean;
import com.wyh.dao.BookDao;

public class BookService {
	BookDao bookDao = new BookDao();
	public boolean save(BookBean bean){
		
		return bookDao.save(bean);
	}

	public List<BookBean> select(int choice, String value) {
		return bookDao.select(choice,value);
	}

	public boolean delete(int reseiveid) {
		return bookDao.delete(reseiveid);
	}

	public boolean updatebook(BookBean bookBean) {
		return bookDao.update(bookBean);
	}
}

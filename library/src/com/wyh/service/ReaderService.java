package com.wyh.service;


import java.util.List;

import com.wyh.bean.ReaderBean;
import com.wyh.dao.ReaderDao;

public class ReaderService {
	public boolean saveuser(ReaderBean readerBean) {
		ReaderDao readerDao = new ReaderDao();
		return readerDao.save(readerBean);
	}
	public List<ReaderBean> query(){
		ReaderDao readerDao = new ReaderDao();
		return readerDao.query();
	}
	public boolean delete(int id) {
		ReaderDao readerDao = new ReaderDao();
		return readerDao.delete(id);
		
	}
	public List<ReaderBean> select(int reseiveid) {
		ReaderDao readerDao = new ReaderDao();
		return readerDao.select(reseiveid);
	}
	public boolean updatereader(ReaderBean readerBean) {
		ReaderDao readerDao = new ReaderDao();
		return readerDao.update(readerBean);
	}
}

package com.wyh.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyh.bean.ReaderBean;
import com.wyh.service.ReaderService;

public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String behavior = uri.substring(uri.lastIndexOf("/") + 1);
		System.out.println(behavior);
		switch (behavior) {
		case "save.behavior":
		{
			if(request.getSession().getAttribute("userbean")!=null){
				ReaderService readerService = new ReaderService();
				request.setCharacterEncoding("utf-8");
				ReaderBean readerBean = new ReaderBean();
				readerBean.setReadername(request.getParameter("readername"));
				int age = Integer.valueOf(request.getParameter("age"));
				readerBean.setAge(age);
				readerBean.setSex(request.getParameter("sex"));
				readerBean.setEmail(request.getParameter("email"));
				readerBean.setProfession(request.getParameter("profession"));
				request.setAttribute("reader", readerBean);
				if (readerService.saveuser(readerBean)) {
					request.getRequestDispatcher("/WEB-INF/view/usersavesucess.jsp").forward(request, response);
					}
				}
				
				else {
					request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
				}
		}
			break;
			
		case "update.behavior":
		{
			if(request.getSession().getAttribute("userbean")!=null){
		ReaderService readerService = new ReaderService();
		request.setCharacterEncoding("utf-8");
		ReaderBean readerBean = new ReaderBean();
		readerBean.setId(Integer.valueOf(request.getParameter("id")));
		readerBean.setReadername(request.getParameter("readername"));
		int age = Integer.valueOf(request.getParameter("age"));
		readerBean.setAge(age);
		readerBean.setSex(request.getParameter("sex"));
		readerBean.setEmail(request.getParameter("email"));
		readerBean.setProfession(request.getParameter("profession"));
		request.setAttribute("reader", readerBean);
		if (readerService.updatereader(readerBean)) {
			request.getRequestDispatcher("/WEB-INF/view/usersavesucess.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
	}
	break;	
		
		case "readerlist.behavior":
		{
			if(request.getSession().getAttribute("userbean")!=null){
			ReaderService readerService = new ReaderService();
			List<ReaderBean> list = new LinkedList<ReaderBean>();
			list=readerService.query();
			request.setAttribute("list", list);
			for (ReaderBean readerBean : list) {
				System.out.println(readerBean.toString());
			}
			request.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
			break;
		case "delete.behavior":
		{
			if(request.getSession().getAttribute("userbean")!=null){
			ReaderService readerService = new ReaderService();
			int reseiveid = Integer.valueOf(request.getParameter("deleteid"));
			System.out.println(reseiveid);
			if (readerService.delete(reseiveid)){
				request.getRequestDispatcher(uri.replaceAll("delete.behavior", "readerlist.behavior")).forward(request, response);
			}
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
			break;
		case "updatepage.behavior":
		{
			if(request.getSession().getAttribute("userbean")!=null){
			ReaderService readerService = new ReaderService();
			ReaderBean readerBean = new ReaderBean();
			int reseiveid = Integer.valueOf(request.getParameter("updateid"));
			System.out.println(reseiveid);
			List<ReaderBean> rslist = new LinkedList<ReaderBean>();
			rslist = readerService.select(reseiveid);
			for (ReaderBean rB : rslist) {
				readerBean.setId(rB.getId());
				readerBean.setReadername(rB.getReadername());
				readerBean.setAge(rB.getAge());
				readerBean.setSex(rB.getSex());
				readerBean.setEmail(rB.getEmail());
				readerBean.setProfession(rB.getProfession());
				}
			request.setAttribute("rsbean", readerBean);
			request.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
			break;
		default:
			break;
		}
	}
}

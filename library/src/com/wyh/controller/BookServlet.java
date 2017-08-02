package com.wyh.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyh.bean.BookBean;
import com.wyh.bean.ReaderBean;
import com.wyh.service.BookService;
import com.wyh.service.BookService;


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri  = request.getRequestURI();
		String bookdo = uri.substring(uri.lastIndexOf("/") + 1);
		switch (bookdo) {
		case "save_book_page.bookdo":
			if(request.getSession().getAttribute("userbean")!=null){
			request.getRequestDispatcher("/WEB-INF/view/savebook.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}break;
		case "save_book_info.bookdo":
			if(request.getSession().getAttribute("userbean")!=null){
			BookService bookService = new BookService();
			BookBean bookBean = new BookBean();
			request.setCharacterEncoding("utf-8");
			bookBean.setSerialnum(request.getParameter("serialnum"));
			bookBean.setName(request.getParameter("name"));
			bookBean.setPrice(Double.valueOf(request.getParameter("price")));
			bookBean.setBookCount(Integer.valueOf(request.getParameter("count")));
			bookBean.setAuthor(request.getParameter("author"));
			bookBean.setPress(request.getParameter("press"));
			if(bookService.save(bookBean)){
				request.setAttribute("bookbean", bookBean);
				request.getRequestDispatcher("/WEB-INF/view/savesucess.jsp").forward(request, response);
				System.out.println(bookBean.toString());
				}
			}else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			break;
		case "find_book.bookdo":
		{
			if(request.getSession().getAttribute("userbean")!=null){
				BookService bookService = new BookService();
				request.setCharacterEncoding("utf-8");
				System.out.println(request.getParameter("select"));
				int choice = 0;
				if(request.getParameter("select")!=null)
				choice=Integer.valueOf(request.getParameter("select"));
				System.out.println(choice);
				String value =request.getParameter("iftext");
				List<BookBean> rsList = new LinkedList<BookBean>();
				rsList = bookService.select(choice,value);
				for (BookBean bookBean : rsList) {
					System.out.println(bookBean.toString());
				}
				request.setAttribute("rslist", rsList);
				request.getRequestDispatcher("/WEB-INF/view/findlist.jsp").forward(request, response);
				
			}else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
		break;
		case "delete.bookdo":
			if(request.getSession().getAttribute("userbean")!=null){
				BookService bookService = new BookService();
				int reseiveid = Integer.valueOf(request.getParameter("id"));
				System.out.println(reseiveid);
				if (bookService.delete(reseiveid)){
					request.getRequestDispatcher(uri.replaceAll("delete.bookdo", "find_book.bookdo")).forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			break;
		
			
		case "updatepage.bookdo":
		{
			if(request.getSession().getAttribute("userbean")!=null){
			BookService bookService = new BookService();
			BookBean bookBean = new BookBean();
			String reseiveid = request.getParameter("id");
			List<BookBean> rslist = new LinkedList<BookBean>();
			rslist = bookService.select(3, reseiveid);
			for (BookBean rB : rslist) {
				bookBean.setId(rB.getId());
				bookBean.setSerialnum(rB.getSerialnum());
				bookBean.setName(rB.getName());
				bookBean.setPrice(rB.getPrice());
				bookBean.setBookCount(rB.getBookCount());
				bookBean.setAuthor(rB.getAuthor());
				bookBean.setPress(rB.getPress());
				}
			request.setAttribute("bookbean", bookBean);
			request.getRequestDispatcher("/WEB-INF/view/savebook.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
			break;
		case "update.bookdo":
			if(request.getSession().getAttribute("userbean")!=null){
				BookService bookService = new BookService();
				request.setCharacterEncoding("utf-8");
				BookBean bookBean = new BookBean();
				bookBean.setId(Integer.valueOf(request.getParameter("id")));
				bookBean.setSerialnum(request.getParameter("serialnum"));
				bookBean.setName(request.getParameter("name"));
				bookBean.setPrice(Double.valueOf(request.getParameter("price")));
				bookBean.setBookCount(Integer.valueOf(request.getParameter("count")));
				bookBean.setAuthor(request.getParameter("author"));
				bookBean.setPress(request.getParameter("press"));
				request.setAttribute("bookbean", bookBean);
				if (bookService.updatebook(bookBean)) {
					request.getRequestDispatcher("/WEB-INF/view/savesucess.jsp").forward(request, response);
					}
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			break;
		default:
			break;
		}
	}

}

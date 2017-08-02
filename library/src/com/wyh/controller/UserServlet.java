package com.wyh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyh.bean.UserBean;
import com.wyh.service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1);
		System.out.println(action);
		switch (action) {
		case "login.action":
		{	
			
			System.out.println("start!!!");
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username + password);
			try {
				boolean flag1 = userService.checkuser(username, password);
				System.out.println(flag1);
				if (flag1) {
				// Ìø×ªµ½Ö÷Ò³
				HttpSession session = request.getSession();
				UserBean userBean = new UserBean();
				userBean.setName(username);
				session.setAttribute("userbean", userBean);
				request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
				
				} else {
				// Ìø×ªµ½µÇÂ¼
				System.out.println("µÇÂ¼Ê§°Ü");
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
			break;
		case "regist.action":
		{
			if(request.getSession().getAttribute("userbean")!=null){
			String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
			String password = new String(request.getParameter("password").getBytes("iso-8859-1"),"utf-8");
			boolean flag = userService.saveuser(username, password);
			System.out.println(flag);
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		}
			break;
		case "signuppage.action":
			
			if(request.getSession().getAttribute("userbean")!=null){
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			request.getSession().invalidate();
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			break;
		case "registepage.action":
			if(request.getSession().getAttribute("userbean")!=null){
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			break;
		case "userpage.action":
			if(request.getSession().getAttribute("userbean")!=null){
			request.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			break;
		case "userspage.action":
			if(request.getSession().getAttribute("userbean")!=null){
			request.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}break;
		case "homepage.action":
			if(request.getSession().getAttribute("userbean")!=null){
			request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}break;
		case "findpage.action":
			if(request.getSession().getAttribute("userbean")!=null){
				request.getRequestDispatcher("/WEB-INF/view/find.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
				}
			break;
		default:
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			break;
		}
		System.out.println("end!!!");
		
	}

}

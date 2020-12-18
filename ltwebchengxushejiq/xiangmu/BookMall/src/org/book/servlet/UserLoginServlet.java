package org.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.entity.User;
import org.book.servce.UserServce;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		User user = new User();
		user.setUname(name);
		user.setUpwd(pwd);
		request.setAttribute("name", name);
		System.out.println("name£º"+name);
		System.out.println("pwd£º"+pwd);
		UserServce us = new UserServce();
		System.out.println("=======");
		boolean flag = us.queryUser(user);
		System.out.println(flag);
		if(!flag) response.sendRedirect("no.jsp");
		else      request.getRequestDispatcher("QueryAllBook2Servlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

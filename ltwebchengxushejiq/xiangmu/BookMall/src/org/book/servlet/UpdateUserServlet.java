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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		System.out.println(id+"==="+name+"==="+pwd);
		User user = new User();
		user.setUid(id);
		user.setUname(name);
		user.setUpwd(pwd);
		UserServce us = new UserServce();
		boolean flag = us.updateUser(user);
		if(flag) response.sendRedirect("QueryAllUserServlet");
		else     System.out.println("ÐÞ¸ÄÊ§°Ü");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

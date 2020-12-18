package org.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.entity.Admin;
import org.book.servce.AdminServce;

/**
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("aid"));
		String name = request.getParameter("aname");
		String pwd = request.getParameter("apwd");
		System.out.println(id+"==="+name+"==="+pwd);
		Admin admin = new Admin();
		admin.setAid(id);
		admin.setAname(name);
		admin.setApwd(pwd);
		AdminServce as = new AdminServce();
		boolean flag = as.updateAdmin(admin);
		if(flag) response.sendRedirect("QueryAllAdminServlet");
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

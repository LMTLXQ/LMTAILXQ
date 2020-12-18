package org.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.entity.Admin;
import org.book.servce.AdminServce;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("aname");
		String pwd = request.getParameter("apwd");
		System.out.println("aname:"+name);
		System.out.println("apwd:"+pwd);
		Admin admin = new Admin();
		admin.setAname(name);
		admin.setApwd(pwd);
		AdminServce as = new AdminServce();
		boolean flag = as.addAdmin(admin);
		System.out.println(flag);
		if(flag){
			System.out.println("×¢²á³É¹¦");
			response.sendRedirect("QueryAllAdminServlet");
		}else{
			System.out.println("×¢²áÊ§°Ü");
			request.getRequestDispatcher("addAdmin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

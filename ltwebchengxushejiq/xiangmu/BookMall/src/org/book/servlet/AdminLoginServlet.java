package org.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.book.entity.Admin;
import org.book.servce.AdminServce;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		String vc = request.getParameter("validateCode");
		String sc = (String) request.getSession().getAttribute("checkcode");
		System.out.println("name:"+name);
		System.out.println("pwd:"+pwd);
		Admin admin	= new Admin();
		admin.setAname(name);
		admin.setApwd(pwd);
		request.setAttribute("name", name);
		AdminServce as = new AdminServce();
		boolean flag = as.queryAdmin(admin);
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		System.out.println("admin:"+flag);
		System.out.println(vc+"======"+sc);
		
		if(flag){
			if(vc.equals(sc)){
				request.getRequestDispatcher("home.jsp").forward(request, response);///BookMall/WebContent/WEB-INF/home.jsp
				System.out.println("登录成功");
			}else{
				Cookie cookie = new Cookie("login", "验证码错误！");
				response.addCookie(cookie);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else{
			Cookie cookie = new Cookie("login", "用户名或者密码错误！");
			response.addCookie(cookie);
			request.getRequestDispatcher("index.jsp").forward(request, response);
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

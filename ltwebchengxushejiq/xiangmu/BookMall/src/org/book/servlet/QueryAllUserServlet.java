package org.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.entity.Page;
import org.book.entity.User;
import org.book.servce.UserServce;

/**
 * Servlet implementation class QueryAllUserServlet
 */
@WebServlet("/QueryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        UserServce us  = new UserServce();
		int count = us.querySun() ;//��������
		
		//����ҳ�����5���ֶΣ�������1���Զ����㣬���ʵ��ֻ��Ҫ��װ4�����ɣ�����װ��page����֮��
		Page page = new Page();
		
		String cPage = request.getParameter("currentPage")  ;//
		
		if(cPage == null) {
			cPage = "1" ;
		}
		
		int currentPage = Integer.parseInt( cPage );
		page.setCurrentPage(currentPage);
		//ע�� ˳��
		int totalCount = us.querySun() ;//��������
		page.setTotalCount(totalCount);
		
		/* currentPage����ǰҳ��ҳ�룩  
	  	 students :��ǰҳ�����ݼ��ϣ���ǰҳ������ѧ����
		
		*/
		int pageSize = 5;
		page.setPageSize(pageSize);
		List<User>  users  = us.queryAllUser(currentPage, pageSize) ;
		System.out.println(users);
		System.out.println(count);
		
		page.setUsers(users);
		request.setAttribute("p", page);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

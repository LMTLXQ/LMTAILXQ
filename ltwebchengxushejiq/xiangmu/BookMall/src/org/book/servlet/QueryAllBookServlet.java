package org.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.entity.Book;
import org.book.entity.Page;
import org.book.servce.BookServce;

/**
 * Servlet implementation class QueryAllBookServlet
 */
@WebServlet("/QueryAllBookServlet")
public class QueryAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        BookServce bs = new BookServce();
		int count = bs.querySum();//数据总数
		
		Page page = new Page();
		
		
		String cPage = request.getParameter("currentPage")  ;//
		
	
		
		if(cPage == null) {
			cPage = "1" ;
		}
		
		
		int currentPage = Integer.parseInt( cPage );
		page.setCurrentPage(currentPage);
		
		int totalCount = bs.querySum() ;//总数据数
		page.setTotalCount(totalCount);
		int pageSize = 4;
		page.setPageSize(pageSize);
		List<Book>  books  = bs.queryAllBook(currentPage, pageSize) ;
		System.out.println(books);
		System.out.println(count);
		
	
		page.setBooks(books);
		request.setAttribute("p", page);
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

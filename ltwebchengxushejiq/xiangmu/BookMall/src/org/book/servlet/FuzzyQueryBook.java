package org.book.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class FuzzyQueryUser
 */
@WebServlet("/FuzzyQueryBook")
public class FuzzyQueryBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuzzyQueryBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("bname");
//		String name = "∆‰ µ";
		System.out.println(name);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		BookServce bs = new BookServce();
		List<Book> list = new ArrayList<>();
		list = bs.fuzzyQueryBook(name);
		System.out.println(list);
		Page page = new Page();
		page.setBooks(list);
		System.out.println(page);
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

package org.book.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.book.entity.Book;
import org.book.servce.BookServce;


/**
 * Servlet implementation class PetServlet
 */
@WebServlet("/UploadBookServlet")
public class UploadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		boolean isMultiaprt = ServletFileUpload.isMultipartContent(request);//判断
		System.out.println(isMultiaprt);
		if(isMultiaprt){
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				Book book = new Book();
				while(iter.hasNext()){
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					String name = null;
					double price = -1;
					String category = null;
					String introduction = null;
					if(item.isFormField()){
						if(itemName.equals("bname")){
							name = item.getString("utf-8");
							book.setBookName(name);
						}else if (itemName.equals("price")) {
							price = Double.parseDouble(item.getString());
							book.setBookPrice(price);
						}else if(itemName.equals("category")){
							category=item.getString("utf-8");
							book.setBookCategory(category);
						}else if (itemName.equals("introduction")) {
							introduction = item.getString("utf-8");
							book.setBookIntroduction(introduction);
						}else {
							System.out.println("其他");
						}
					}else{
						String fileName = item.getName();//获取文件名
						String path = "E:\\BookMall\\WebContent\\image";///BookMall/WebContent/image/616364793.jpeg
						String imagePath = path+"\\"+fileName;
						System.out.println(path);
						File file = new File(path,fileName);
						try {
							item.write(file);
							book.setBookImage(imagePath);
							System.out.println(fileName+"上传成功");
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				BookServce bs = new BookServce();
				boolean flag = bs.uploadBook(book);
				if(flag) {
					response.sendRedirect("QueryAllBookServlet");
					System.out.println("图书信息上传至数据库成功");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



}

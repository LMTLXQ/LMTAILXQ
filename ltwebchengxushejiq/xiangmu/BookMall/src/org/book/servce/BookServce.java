package org.book.servce;

import java.util.List;

import org.book.dao.BookDao;
import org.book.entity.Book;

public class BookServce {
	//上传书籍
	public boolean uploadBook(Book book){
		return BookDao.uploadBook(book);
	}
	
	//查询所有书籍
	public List<Book> queryAllBook(int currentPage, int pageSize) {
		return BookDao.queryAllBook(currentPage, pageSize);
	}
	
	//查询图书总数
	public int querySum(){
		return BookDao.querySum();
	}
	//修改图书信息
	public boolean updateBook(Book book){
		return BookDao.updateBook(book);
	}
	
	//删除图书
	public boolean deleteBook(int id){
		return BookDao.deleteBook(id);
	}
	
	//查询说有图书
	public List<Book> queryAllBook2(){
		return BookDao.queryAllBook2();
	}
	
	//模糊查询图书
	public List<Book> fuzzyQueryBook(String name){
		return BookDao.fuzzyQueryBook(name);
	}
}

package org.book.servce;

import java.util.List;

import org.book.dao.BookDao;
import org.book.entity.Book;

public class BookServce {
	//�ϴ��鼮
	public boolean uploadBook(Book book){
		return BookDao.uploadBook(book);
	}
	
	//��ѯ�����鼮
	public List<Book> queryAllBook(int currentPage, int pageSize) {
		return BookDao.queryAllBook(currentPage, pageSize);
	}
	
	//��ѯͼ������
	public int querySum(){
		return BookDao.querySum();
	}
	//�޸�ͼ����Ϣ
	public boolean updateBook(Book book){
		return BookDao.updateBook(book);
	}
	
	//ɾ��ͼ��
	public boolean deleteBook(int id){
		return BookDao.deleteBook(id);
	}
	
	//��ѯ˵��ͼ��
	public List<Book> queryAllBook2(){
		return BookDao.queryAllBook2();
	}
	
	//ģ����ѯͼ��
	public List<Book> fuzzyQueryBook(String name){
		return BookDao.fuzzyQueryBook(name);
	}
}

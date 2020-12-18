package org.book.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.book.entity.Admin;
import org.book.entity.Book;
import org.book.entity.User;
import org.book.util.DBUtil;

public class BookDao {
	//���ϴ�
	public static boolean uploadBook(Book book){
		String sql = "insert into book values(null,?,?,?,?,?)";
		Object[] params = {book.getBookImage(),book.getBookName(),book.getBookPrice(),book.getBookCategory(),book.getBookIntroduction()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//��ѯ�����鼮
	public static List<Book> queryAllBook(int currentPage, int pageSize) {

		ResultSet rs = null;
		String sql = "select * from book limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,currentPage*pageSize};
		List<Book> list = new ArrayList<>();
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				Book book = new Book();//user����Ҫд��whileѭ���ڣ���Ȼuser�ڵ����ݻᱻ���һ�������滻
				book.setBookID(rs.getInt("book_id"));
				book.setBookImage(rs.getString("book_image"));
				book.setBookName(rs.getString("book_name"));
				book.setBookPrice(rs.getDouble("book_price"));
				book.setBookCategory(rs.getString("book_category"));
				book.setBookIntroduction(rs.getString("book_introduction"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return list;
	}
	
	//��ѯ�����鼮
	public static List<Book> queryAllBook2() {

		ResultSet rs = null;
		String sql = "select * from book";
		Object[] params = null;
		List<Book> list = new ArrayList<>();
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				Book book = new Book();//user����Ҫд��whileѭ���ڣ���Ȼuser�ڵ����ݻᱻ���һ�������滻
				book.setBookID(rs.getInt("book_id"));
				book.setBookImage(rs.getString("book_image"));
				book.setBookName(rs.getString("book_name"));
				book.setBookPrice(rs.getDouble("book_price"));
				book.setBookCategory(rs.getString("book_category"));
				book.setBookIntroduction(rs.getString("book_introduction"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return list;
	}
	
	//��ѯͼ������
	public static int querySum(){
		ResultSet rs = null;
		String sql = "select count(1) from book";
		Object[] params = null;
		rs = DBUtil.executeQuery(sql, params);
		int sum = -1;
		try {
			if(rs.next()){
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return sum;
	}
	
	//�޸�ͼ����Ϣ
	public static boolean updateBook(Book book){
		String sql = "update book set book_image=?,book_name=?,book_price=?,book_category=?,book_introduction=?  where book_id =?";
		Object[] params = {book.getBookImage(),book.getBookName(),book.getBookPrice(),book.getBookCategory(),book.getBookIntroduction(),book.getBookID()};
		return DBUtil.executeUpdate(sql, params);
	}
	//ɾ��ͼ��
	public static boolean deleteBook(int id){
		String sql = "delete from book where book_id = ?";
		Object[] params = {id};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//ģ����ѯͼ��
	public static List<Book> fuzzyQueryBook(String name){
		ResultSet rs = null;
		String sql = "select * from book where book_name like ?";
		String name1 = "%"+name+"%";
		Object[] params ={name1};
		List<Book> list = new ArrayList<>();
		rs=DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				Book book = new Book();
				book.setBookID(rs.getInt("book_id"));
				book.setBookImage(rs.getString("book_image"));
				book.setBookName(rs.getString("book_name"));
				book.setBookPrice(rs.getDouble("book_price"));
				book.setBookCategory(rs.getString("book_category"));
				book.setBookIntroduction(rs.getString("book_introduction"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return list;
	}
}

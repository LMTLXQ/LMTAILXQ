package org.book.entity;

import java.util.List;

//分页帮助�?
public class Page {
//	当前�?  currentPage
	private int currentPage;
//	页面大小 pageSize
	private int pageSize ;

//	总数�? totalCount
	private int totalCount;
//	总页�?   totalPage
	private int totalPage ;
	
//	当前页的数据集合  
	
	private List<User> users;
	private List<Admin> admins;
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Page() {
	}

	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<User> users,List<Admin> admins) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.users = users;
		this.admins = admins;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	/*
	 * 总页�? = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
	 * 
	 * 当我们调换用�? 数据总数的set() �? 页面大小的set()以后，自动计算出 总页�?
	 * 务必注意顺序：先set 数据总数   再set 页面大小
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		//自动计算�? 总页�?
	
//		总页�? = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
		this.totalPage =this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:totalCount/this.pageSize+1; 
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	//给�?�页数赋�?
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}

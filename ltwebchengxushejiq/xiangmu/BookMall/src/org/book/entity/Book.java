package org.book.entity;

public class Book {
	private String bookImage;
	private String bookName;
	private double bookPrice;
	private String bookCategory;
	private String bookIntroduction;
	private int bookID;
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public Book() {
	}
	public Book(String bookImage, String bookName, double bookPrice, String bookCategory, String bookIntroduction,int bookID) {
		super();
		this.bookImage = bookImage;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookCategory = bookCategory;
		this.bookIntroduction = bookIntroduction;
		this.bookID = bookID;
	}
	@Override
	public String toString() {
		return "Book [bookImage=" + bookImage + ", bookName=" + bookName + ", bookPrice=" + bookPrice
				+ ", bookCategory=" + bookCategory + ", bookIntroduction=" + bookIntroduction + ", bookID=" + bookID
				+ "]";
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getBookIntroduction() {
		return bookIntroduction;
	}
	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}
}

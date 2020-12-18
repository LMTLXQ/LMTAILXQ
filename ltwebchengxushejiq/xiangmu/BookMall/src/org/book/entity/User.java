package org.book.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private List<User> users = new ArrayList<>();
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User() {
	}
	public User(int uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
}

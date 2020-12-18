package org.book.entity;

public class Admin {
	private int aid;
	private String aname;
	private String apwd;
	public Admin() {
	}
	public Admin(int aid, String aname, String apwd) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
}

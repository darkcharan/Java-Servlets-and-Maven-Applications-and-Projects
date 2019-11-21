package com.shop.Bean;

public class UserBean {

	
	private int uid;
	private String uname;
	private long mobileno;
	private String uaddr;
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
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	@Override
	public String toString() {
		return " " + uid + "\t" + uname + "\t" + mobileno + "\t" + uaddr + "";
	}
	public UserBean(int uid, String uname, long mobileno, String uaddr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.mobileno = mobileno;
		this.uaddr = uaddr;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

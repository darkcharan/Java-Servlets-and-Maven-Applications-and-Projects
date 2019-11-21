package com.user.bean;

public class UserBean {
	String uname;
	String pwd;
	String email;
	long mobile;
	public UserBean(String uname, String pwd, String email, long mobile) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.mobile = mobile;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "" + uname + "\t" + pwd + "\t" + email + "\t" + mobile + "";
	}
	
	
	

}

package com.student.bean;

public class StudentBean {
	private int sno;
	private String sname;
	private String sadd;
	public StudentBean(int sno, String sname, String sadd) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "" + sno + "" + sname + "" + sadd + "";
	}
	
	

}
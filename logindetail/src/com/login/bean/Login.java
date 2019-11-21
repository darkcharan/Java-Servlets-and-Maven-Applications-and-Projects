package com.login.bean;

public class Login {
	
	private String name;
	private String fname;
	private String country;
	private String gender;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String name, String fname, String country, String gender) {
		super();
		this.name = name;
		this.fname = fname;
		this.country = country;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

package com.shop.Bean;

public class UserProd {

	private int pid;
	private String pname;
	private String pbrand;
	private float price;
	private int quantity;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "UserProd [pid=" + pid + ", pname=" + pname + ", pbrand=" + pbrand + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

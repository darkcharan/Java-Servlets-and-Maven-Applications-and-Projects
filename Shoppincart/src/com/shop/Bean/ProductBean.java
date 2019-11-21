package com.shop.Bean;

public class ProductBean {

	private int pid;
	private String pname;
	private String pbrand;
	private String pcategory;
	private int pquantity;
	private float prprice;
	
	
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
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public float getPrprice() {
		return prprice;
	}
	public void setPrprice(float prprice) {
		this.prprice = prprice;
	}
	@Override
	public String toString() {
		return " " + pid + "\t" + "\t" + pname + "\t" + "\t"+ pbrand +"\t"+"\t" + pcategory
				+ "\t" + "\t"+ pquantity + "\t" + "\t"+ prprice + "\t"+" ";
	}
	public ProductBean(int pid, String pname, String pbrand, String pcategory, int pquantity, float prprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pbrand = pbrand;
		this.pcategory = pcategory;
		this.pquantity = pquantity;
		this.prprice = prprice;
	}
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

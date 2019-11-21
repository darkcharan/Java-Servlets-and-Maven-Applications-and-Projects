package com.shop.admin;

import com.shop.Bean.ProductBean;

public interface Admin {

	int addproducts(ProductBean pb);
	ProductBean viewbyid(int pid);
	int updateproducts(ProductBean pb);
	int removeproducts(int productid);
	
	
}

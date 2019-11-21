package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Bean.ProductBean;
import com.shop.admin.AdminImpl;

/**
 * Servlet implementation class UpdateProdServlet
 */
@WebServlet("/UpdateProdServlet")
public class UpdateProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminImpl ai=new AdminImpl();
		List<ProductBean> list=  ai.viewall();
		PrintWriter pw=response.getWriter();
        pw.print("<table border='1' width='100%'");  
        pw.print("<tr><th>Id</th><th>Name</th><th>Brand</th><th>Category</th><th>Quanity</th><th>Price</th><th>Edit</th><th>Delete</th></tr>");  
        for(ProductBean e:list){  
         pw.print("<tr><td>"+e.getPid()+"</td><td>"+e.getPname()+"</td><td>"+e.getPbrand()+
        		 "</td><td>"+e.getPcategory()+"</td><td>"+e.getPquantity()+"</td><td>"+e.getPrprice()+"</td><td><a href='EditServlet?id="+e.getPid()+ 
        		 "'>edit</a></td><td><a href='RemoveProductServlet?id="+e.getPid()+"'>delete</a></td></tr>");  
        }  
        pw.print("</table>");  
        pw.print("<br>");
        pw.print("<a href=admin.html> AdminHome</a>");
	}

	
}

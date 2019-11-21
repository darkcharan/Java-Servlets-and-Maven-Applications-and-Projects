package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Bean.ProductBean;
import com.shop.admin.Admin;
import com.shop.admin.AdminImpl;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();      
	        int pid= Integer.parseInt(request.getParameter("pid"));
			String pname=request.getParameter("pname");
			String brand=request.getParameter("pbrand");
			String pcategory=request.getParameter("pcat");
			int pqty= Integer.parseInt(request.getParameter("pqty"));
			float price=Float.parseFloat(request.getParameter("price")); 
	          
			ProductBean pb= new ProductBean(pid,pname,brand,pcategory,pqty,price);
			Admin ai=new AdminImpl();  
	        int status=ai.updateproducts(pb);  
	        if(status!=0){  
	            response.sendRedirect("UpdateProdServlet");  
	        }
	        else{  
	        	
	            out.println("Sorry! unable to update record"); 
	            response.sendRedirect("admin.html");
	        }  
	          
	        out.close();  
	    }
	
			
		
	}

	


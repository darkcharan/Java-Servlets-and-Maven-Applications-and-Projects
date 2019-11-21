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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Product</h1>");  
        String pid=request.getParameter("id");  
        int id=Integer.parseInt(pid);  
        Admin ai=new AdminImpl();
       ProductBean e=ai.viewbyid(id); 
          
        out.print("<form action='EditServlet2'");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='pid' value='"+e.getPid()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='pname' value='"+e.getPname()+"'/></td></tr>");  
        out.print("<tr><td>Brand:</td><td><input type='text' name='pbrand' value='"+e.getPbrand()+"'/></td></tr>");  
        out.print("<tr><td>Category:</td><td><input type='text' name='pcat' value='"+e.getPcategory()+"'/></td></tr>");  
        out.print("<tr><td>quanityt</td><td><input type='text' name='pqty' value='"+e.getPquantity()+"'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+e.getPrprice()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
		
		
		
	}

	
	

}

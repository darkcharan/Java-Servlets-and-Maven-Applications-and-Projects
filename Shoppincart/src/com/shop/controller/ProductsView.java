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
import com.shop.user.UserImpl;

/**
 * Servlet implementation class ProductsView
 */
@WebServlet("/ProductsView")
public class ProductsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		UserImpl ui = new UserImpl();
		String category=request.getParameter("category");
		if("men".equals(category))
		{
			
		List<ProductBean>lp=ui.selectcategory(category);
		out.print("<table border='1' width='100%'");  
        out.print("<tr><th>PoductId</th><th>Name</th><th>Brand</th><th>Quantity</th><th>Price</th><th>Select</th>");  
        for(ProductBean pb:lp){  
         out.print("<tr><td>"+pb.getPid()+"</td><td>"+pb.getPname()+"</td><td>"+pb.getPbrand()+
        		 "</td><td>"+pb.getPquantity()+"</td><td>"+pb.getPrprice()+"</td><td><a href='SelectServlet?id="+pb.getPid()+"'>Select</a></td>"); 
	        		 
	        }  
	        out.print("</table>");  
	        
	     }
		
		
		else
		{
			if("women".equals(category))
			{
				
				List<ProductBean>lp=ui.selectcategory(category);
				out.print("<table border='1' width='100%'");  
		        out.print("<tr><th>PoductId</th><th>Name</th><th>Brand</th><th>Quantity</th><th>Price</th><th>Select</th>");  
		        for(ProductBean pb:lp){  
		         out.print("<tr><td>"+pb.getPid()+"</td><td>"+pb.getPname()+"</td><td>"+pb.getPbrand()+
		        		 "</td><td>"+pb.getPquantity()+"</td><td>"+pb.getPrprice()+"</td><td><a href='SelectServlet?id="+pb.getPid()+"'>Select</a></td>"); 
		        		 
		        }  
		        out.print("</table>");  
				
			}
		}
		
		
		/*out.println("<form action=SelectServlet>");
		out.println("Choose the product ID:");
		out.println("<input type=text name=pid>"+"<br>");
		out.println("Choose the product quantity:");
		out.println("<input type=text name=qty>"+"<br>");
		out.println("<input type=submit value=add>");
		out.println("</form>");*/
		
	}
}

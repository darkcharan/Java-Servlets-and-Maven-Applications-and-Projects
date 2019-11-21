package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.shop.Bean.UserProd;
import com.shop.user.UserImpl;

/**
 * Servlet implementation class DisplayCart
 */
@WebServlet("/DisplayCart")
public class DisplayCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();  
	     int uid=(int) session.getAttribute("id");
		
		UserImpl ui= new UserImpl();
		PrintWriter pw=response.getWriter();
		pw.println("<form action=payment.html>");
		pw.println("<table>");
		//pw.print("<tr><th>PoductId</th><th>Name</th><th>Brand</th><th>Price</th><th>Quantity</th><th>Delete</th>");
		List<UserProd> l=ui.purchase(uid);
		pw.print("<table border='1' width='100%'");  
        pw.print("<tr><th>PoductId</th><th>Name</th><th>Brand</th><th>Price</th><th>Quantity</th><th>Delete From Cart</th>");  
        for(UserProd pb:l){  
         pw.print("<tr><td>"+pb.getPid()+"</td><td>"+pb.getPname()+"</td><td>"+pb.getPbrand()+
        		 "</td><td>"+pb.getPrice()+"</td><td>"+pb.getQuantity()+"</td><td><a href='DeleteCartServlet?id="+pb.getPid()+"'>Select</a></td>"); 
        		 
        }  
        pw.print("</table>");  
		Float price1=ui.totalprice(uid);
		float dprice=0;
		if(price1< 10000)
	    {
	    	dprice=price1;
	    }
	    else
	    {
	    	if(price1 > 10000)
	    	{
	    		dprice=(float) (price1*0.1);
	    	}
	    		else
	    		{
	    				if(price1 >10001 || price1 < 25000)
	    					{
	    						dprice=(float) (price1*0.25);
	    					}
	    				else
	    						if(price1>25001 || price1 < 50000)
	    							{
	    								dprice=(float) (price1*0.5);
	    							}
	    		}	
	    }
		
		
		pw.println("Total Price before Discount:");
		pw.println(price1+"<br>");
		pw.println("Total Price After Discount:");
		pw.println(dprice +"<br>");
		pw.println("<input type=submit value=Payment>");
		pw.println("</form>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}

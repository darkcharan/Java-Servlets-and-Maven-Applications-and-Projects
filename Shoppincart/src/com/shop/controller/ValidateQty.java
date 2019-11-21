package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.user.UserImpl;

/**
 * Servlet implementation class ValidateQty
 */
@WebServlet("/ValidateQty")
public class ValidateQty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateQty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession(false);  
		PrintWriter pw=response.getWriter();
		String qty1=request.getParameter("qty");
		int qty=Integer.parseInt(qty1);
		String pid1=request.getParameter("id");
		int pid=Integer.parseInt(pid1);
		
		UserImpl ui=new UserImpl();
		int valid=ui.quantityvalidate(qty, pid);
		if(valid==1)
		{
			
			/*Cookie[] c= request.getCookies();
			String uid1=c[1].getValue();
			int uid=Integer.parseInt(uid1);*/
			
		    int uid=(int) session.getAttribute("id");
			Float price=ui.calculateprice(pid, qty);
			ui.userprod(price, qty, uid, pid);
			pw.println("Added to cart");
			pw.println("<form action=TotalPrice>");
			pw.println("Do you still want to shop?");
			pw.println("<input type=radio name=choice value=yes>Yes");
			pw.println("<input type=radio name=choice value=no>No");
			pw.println("<input type=hidden name=id value='"+pid+"'>");
			pw.println("<input type=hidden name=qty value='"+qty+"'>");
			pw.println("<input type=submit value=click>");
			pw.println("</form>");
			//pw.println(uid);
		}
		
		
		
		
	}

}

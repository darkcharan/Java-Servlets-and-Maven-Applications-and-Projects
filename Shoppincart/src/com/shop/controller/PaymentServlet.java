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
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		PrintWriter pw=response.getWriter();
		UserImpl ui=new UserImpl();
		ui.deleteuserprod(uid);
		String choice=request.getParameter("payment");
		
		if("card".equals(choice))
		{
			pw.println("<form action=end.html>");
			pw.println("Enter Card No<input type=number>"+"<br>");
			pw.println("Enter Card CVV<input type=number>"+"<br>");
			pw.println("<input type=submit value=Pay>");
			pw.println("</form>");
		
		}
		else
		{
			pw.println("<form action=end.html>");
			pw.println("Cash on Delivery");
			pw.println("Enter Address<input type=text>"+"<br>");
			pw.println("<input type=submit value=Done>"+"<br>");
			pw.println("<summary>Please pay cash when Issues Items</summary>");
			pw.println("</form>");
			
		}
		
		session.invalidate();
	}

	

}

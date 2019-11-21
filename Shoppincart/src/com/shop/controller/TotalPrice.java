package com.shop.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.admin.AdminImpl;


/**
 * Servlet implementation class TotalPrice
 */
@WebServlet("/TotalPrice")
public class TotalPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Cookie[] c= request.getCookies();
		String uid1=c[1].getValue();
		int uid=Integer.parseInt(uid1);*/
		
		String qty1=request.getParameter("qty");
		int qty=Integer.parseInt(qty1);
		String pid1=request.getParameter("id");
		int pid=Integer.parseInt(pid1);
		AdminImpl admin=new AdminImpl();
		admin.updateproductqty(pid, qty);
		
		String choice=request.getParameter("choice");
		
		if("yes".equals(choice))
		{
			RequestDispatcher rd= request.getRequestDispatcher("ViewProd");
			rd.forward(request,response);
			
		}
		
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("DisplayCart");
			rd.forward(request,response);
		}
		
		
		
	}

	
}

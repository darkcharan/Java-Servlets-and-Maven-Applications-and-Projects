package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		
		pw.println("<form action=ValidateQty>");
		pw.println("Enter the quantity:<input type=text name=qty>");
		pw.println("<input type=hidden name=id value='"+id+"'>");
		pw.println("<input type=submit value=click>");
		pw.println("</form>");
		
		
		}

		
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String qty1=request.getParameter("qty");
		int qty=Integer.parseInt(qty1);
		
		pw.println(id +" "+ "qty is"+qty);
		
		UserImpl ui=new UserImpl();
		ui.quantityvalidate(qty,id);*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

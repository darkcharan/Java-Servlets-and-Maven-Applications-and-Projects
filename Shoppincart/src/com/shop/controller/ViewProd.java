package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProd
 */
@WebServlet("/ViewProd")
public class ViewProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw= response.getWriter();
		pw.println("<form action=ProductsView>");
		pw.println("Select Category:"+"<br>");
		pw.println("<input type=radio name=category value=men>Men"+"<br>");
		pw.println("<input type=radio name=category value=women>Women"+"<br>");
		pw.println("<input type=submit value=select>");
		
		
		
	}

	
}

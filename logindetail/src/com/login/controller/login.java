package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.bean.Login;
import com.login.daoimpl.LoginDaoImpl;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String fname=request.getParameter("fname");
		String country=request.getParameter("country");
		String gender=request.getParameter("gender");
		Login login=new Login(name,fname,country,gender);
		LoginDaoImpl daoimpl=new LoginDaoImpl();
		int count=daoimpl.insert(login);
		request.setAttribute("count",count);
		RequestDispatcher rd=null;
		if(count!=0)
		{
			rd=request.getRequestDispatcher("/sucess.html");
		rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("/failure.html");
			rd.forward(request, response);	
		}
		
		
	}

}

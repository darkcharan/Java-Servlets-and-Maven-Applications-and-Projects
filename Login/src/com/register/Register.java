package com.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserBean;
import com.userdao.UserDaoImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserDaoImpl daoImpl=null;
	public void init()
	{
		daoImpl=new UserDaoImpl();
	}
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	   String email=request.getParameter("email");
	   long mobile=Long.parseLong(request.getParameter("mobile"));
	   UserBean userbean=new UserBean(username,password,email,mobile);
	  int res= daoImpl.register(userbean);
	  RequestDispatcher rd=null;
	  if(res!=0)
	  {
		  rd=request.getRequestDispatcher("/success.html");
		  rd.forward(request, response);
	  }
	  else
	  {
		  rd=request.getRequestDispatcher("/failure.html");
		  rd.forward(request, response);
	  }
	
	
	}

	
}

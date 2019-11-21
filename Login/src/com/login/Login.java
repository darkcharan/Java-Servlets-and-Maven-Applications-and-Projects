package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userdao.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserDaoImpl daoImpl=null;
	public void init()
	{
		daoImpl=new UserDaoImpl();
	}
    public Login() {
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
	int count=daoImpl.login(username, password);
	PrintWriter pw=response.getWriter();
	if(count!=0)
	{
		pw.println("Login Success Enjoy the site");
		pw.println("<center><a href=Login.html>Login</a></center>");

	}
		else
		{
			pw.println("Login Not SuccessFull");
			pw.println("<center><a href=Login.html>Login</a></center>");

		}
	
	
	
	}

}

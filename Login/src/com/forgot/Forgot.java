package com.forgot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userdao.UserDaoImpl;

/**
 * Servlet implementation class Forgot
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserDaoImpl daoimpl=null;
	public void init()
	{
		daoimpl=new UserDaoImpl();
	}
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username=request.getParameter("uname");
		String pass=daoimpl.forgot(username);
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(pass!=null)
		{
			pw.println("Your PassWord Is :"+pass);
		pw.println("<center><a href=Login.html>Login</a></center>");
		
		}
			else
			{
				pw.println("Unable to process Ur request try later");
				pw.println("<center><a href=Login.html>Login</a></center>");
				
			}
	}


}

package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.user.UserImpl;

/**
 * Servlet implementation class User login 
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String mno1=request.getParameter("upwd");
		long mno=Long.parseLong(mno1);
		
		UserImpl ui= new UserImpl();
		int check=ui.login(uname, mno);
		if(check!=0)
		{
			pw.println("Welcome"+ uname);
			RequestDispatcher rd=request.getRequestDispatcher("ViewProd");
	        rd.forward(request,response);
	        session.setAttribute("name", uname);
	        session.setAttribute("id",check);
	        
	       /* Cookie c= new Cookie("name",uname);
			Cookie ck= new Cookie("id",Integer.toString(check));
			c.setMaxAge(4000000);
			ck.setMaxAge(4000000);
			response.addCookie(c);
			response.addCookie(ck);*/
			
			
						
		}
		
		
	}

}

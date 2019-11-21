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

import com.shop.Bean.UserBean;
import com.shop.user.UserImpl;

/**
 * Servlet implementation class UserRegServlet
 */
@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		UserImpl ui=new UserImpl();
		String uid1=request.getParameter("uid");
		int uid=Integer.parseInt(uid1);
		int check=ui.usereg(uid);
		{
			if(check==0)
			{
				String uname=request.getParameter("uname");
				int check1=ui.usereg(uname);
				if(check1==0)
				{
					String mno1=request.getParameter("upwd");
					long mno=Long.parseLong(mno1);
					String uaddr=request.getParameter("uaddr");
					UserBean ub=new UserBean(uid,uname,mno,uaddr);
					int check2=ui.usereg(ub);
					
					if(check2!=0)
					{	
				        session.setAttribute("name", uname);
				        session.setAttribute("id",uid);
						pw.println("Welcome"+ uname+"<br>");
						pw.println("User Successfully Registered");
				        RequestDispatcher rd=request.getRequestDispatcher("ViewProd");
				        rd.forward(request,response);
						/*Cookie c= new Cookie("name",uname);
						Cookie ck= new Cookie("id",Integer.toString(uid));
						c.setMaxAge(4000000);
						ck.setMaxAge(4000000);
						response.addCookie(c);
						response.addCookie(ck);	*/
				        
						
					}
				}
				
			}
			
			else
			{
			         	
				pw.println("<br>"+ "Duplicate UserID or UserName");
				pw.println("<a href=UserReg.html>Register"+"<br>");
				pw.println("<a href=UserLogin.html>Login");
				
			}
		}
		
		
		
	}

	
}

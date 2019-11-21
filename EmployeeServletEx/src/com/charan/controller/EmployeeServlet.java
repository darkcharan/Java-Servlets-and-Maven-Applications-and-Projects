package com.charan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.charan.bean.Employee;
import com.charan.daoImpl.EmployeeDaoImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    EmployeeDaoImpl daoImpl=null;
    public void init()
    {
    	
    	System.out.println(daoImpl+"hiiiii");
    }
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eno=Integer.parseInt(request.getParameter("eno"));
		String ename=request.getParameter("ename");
		String eadd=request.getParameter("eadd");
		Employee emp=new Employee(eno,ename,eadd);
		daoImpl=new EmployeeDaoImpl();
		int count=daoImpl.insert(emp);
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

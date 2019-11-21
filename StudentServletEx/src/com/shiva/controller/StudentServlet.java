package com.shiva.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shiva.bean.Student;
import com.shiva.dao.impl.StudentDaoImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StudentDaoImpl daoImpl=null;
	public void init()
	{
		daoImpl=new StudentDaoImpl();
	}
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	//capture the information coming from view component
		int sno=Integer.parseInt(request.getParameter("sno"));
		String sname=request.getParameter("sname");
		String sadd=request.getParameter("sadd");
		Student st=new Student(sno,sname,sadd);
		//call studentDaoimplection methods
		int count=daoImpl.insert(st);
		request.setAttribute("count",count);
		RequestDispatcher rd=null;
		if(count!=0)
		{
			rd=request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("/failure.jsp");
			rd.forward(request, response);	
		}
		
		
		
		
	
	
	}

}

package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


import com.student.bean.StudentBean;
import com.student.dao.StudentDaoImpl;

/**
 * Servlet implementation class StudentController
 */
/*@WebServlet("/StudentController")
*/public class StudentController extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int sno=Integer.parseInt(request.getParameter("sno"));
	String sname=request.getParameter("sname");
	String sadd=request.getParameter("sadd");
	
	StudentDaoImpl daoimpl=new StudentDaoImpl();
	StudentBean st=new StudentBean(sno,sname,sadd);
	
	
	int count=	daoimpl.insert(st);
	
	PrintWriter pw=response.getWriter();
response.setContentType("text/html");
	if(count!=0)
	{
		pw.println("Data Inserted Successfully");
		pw.println("<a href=student.html>Home</a>");
		pw.println("<a href=retrive.html>Retrive</a>");
	}
	else
	{
		pw.println("Data not Inserted Successfully");
		pw.println("<a href=student.html>Home</a>");
		pw.println("<a href=retrive.html>Retrive</a>");
	}
		
		
	}

		
	}



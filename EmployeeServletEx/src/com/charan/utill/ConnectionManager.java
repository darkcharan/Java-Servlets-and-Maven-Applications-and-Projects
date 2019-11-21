package com.charan.utill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	static Connection con=null;
	public static Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException 
	{
		Properties pro=new Properties();
		pro.load(new FileInputStream("C://Users/LOxCharan/eclipse-workspace/servletApplications/EmployeeServletEx/src/db.properties"));
		Class.forName(pro.getProperty("class"));
		con=DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("uname"),pro.getProperty("pass"));
		if(con!=null)
		{
			System.out.println("connection is established");
		}
		else
		{
			System.out.println("connection is not established");
		}
		return con;
	}
		public void release(Connection con,PreparedStatement ps) throws SQLException
		{
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
				
		}
		
	}



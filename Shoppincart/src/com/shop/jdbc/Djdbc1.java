package com.shop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Djdbc1 {
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException

	{
		Connection con=null;
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			if(con!=null)
				System.out.println("Connection is established");
			else
				System.out.println("Connection is not established");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
	
	public static void release(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		if(con!=null)
			con.close();
		
	}

	public static void release(Connection con, Statement st) throws SQLException {
		// TODO Auto-generated method stub
		if(con!=null)
			con.close();
		if(st!=null)
			st.close();
		
	}

	public static void release(Connection con, Statement st, ResultSet s) throws SQLException {
		// TODO Auto-generated method stub
		if(s!=null)
			s.close();
		if(con!=null)
			con.close();
		if(st!=null)
			st.close();
		
	}
	
	public static void release(Connection con, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if(ps!=null)
			ps.close();
		  if(con!=null)
			  con.close();
	}
	

	

}

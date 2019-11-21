package com.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connectionmanager.ConnectionManager;
import com.user.bean.UserBean;

public class UserDaoImpl implements UserDao {

	Connection con=null;
	PreparedStatement ps=null;
	@Override
	public int login(String uname, String pwd) 
	{
		ResultSet rs=null;
		int count=0;
		try 		{
			// TODO Auto-generated method stub
			con=ConnectionManager.getConnection();
	ps=con.prepareStatement("select uname,password from userdetails where uname=? and password =?");
	
	ps.setString(1,uname);
	ps.setString(2,pwd);
	rs=ps.executeQuery();
	rs.next();
	String username=rs.getString(1);
	String password=rs.getString(2);

	if(uname.equals(username)&&pwd.equals(password))
	{
		count++;
	}
			

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		return count;
	}

	@Override
	public int register(UserBean ub) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into userdetails values(?,?,?,?)");
			ps.setString(1,ub.getUname());
			ps.setString(2,ub.getPwd());
			ps.setString(3,ub.getEmail());
			ps.setLong(4,ub.getMobile());
			count=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String forgot(String uname) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		String password=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select password from userdetails where uname=?");
			ps.setString(1,uname);
			rs=ps.executeQuery();
			if(rs.next())
			{
				password=rs.getString(1);		
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

}

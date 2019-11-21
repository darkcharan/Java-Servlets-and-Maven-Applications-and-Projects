package com.login.daoimpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.login.bean.Login;
import com.login.dao.LoginDao;
import com.login.query.QueryConstants;
import com.login.utill.ConnectionManager;


public class LoginDaoImpl implements LoginDao {
	
	Connection con=null;
	PreparedStatement ps=null;

	@Override
	public int insert(Login log) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			ps.setString(1,log.getName());
			ps.setString(2,log.getFname());
			ps.setString(3,log.getCountry());
			ps.setString(4,log.getGender());
count=ps.executeUpdate();
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int retrive(Login log) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.RETRIVE_QUERY);
			ps.setString(1,log.getName());
			ps.setString(2,log.getFname());
			ps.setString(3,log.getCountry());
			ps.setString(4,log.getGender());
count=ps.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}

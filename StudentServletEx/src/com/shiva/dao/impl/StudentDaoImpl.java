package com.shiva.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shiva.bean.Student;
import com.shiva.dao.StudentDao;
import com.shiva.query.QueryConstants;
import com.shiva.util.ConnectionManager;

public class StudentDaoImpl implements StudentDao {

	Connection con=null;
	PreparedStatement ps=null;
	@Override
	public int insert(Student stu) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			ps.setInt(1,stu.getSno());
			ps.setString(2,stu.getSname());
			ps.setString(3,stu.getSadd());
count=ps.executeUpdate();
return count;
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}

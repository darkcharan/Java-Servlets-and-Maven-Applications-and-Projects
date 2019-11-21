package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.student.bean.StudentBean;
import com.student.query.QueryConstants;
import com.student.utill.ConnectionManager;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int insert(StudentBean st) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			ps.setInt(1,st.getSno());
			ps.setString(2,st.getSname());
			ps.setString(3,st.getSadd());
			count=ps.executeUpdate();
			
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return count;
	}

	@Override
	public StudentBean retrive(int sno) {
		// TODO Auto-generated method stub
		return null;
	}

}

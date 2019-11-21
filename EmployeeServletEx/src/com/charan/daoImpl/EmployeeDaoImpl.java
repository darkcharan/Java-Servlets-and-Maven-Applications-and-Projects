package com.charan.daoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.charan.bean.Employee;
import com.charan.dao.EmployeeDao;
import com.charan.query.QueryConstants;
import com.charan.utill.ConnectionManager;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con=null;
	PreparedStatement ps=null;

	@Override
	public int insert(Employee emp) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			ps.setInt(1,emp.getEno());
			ps.setString(2,emp.getEname());
			ps.setString(3, emp.getEadd());
			count=ps.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}

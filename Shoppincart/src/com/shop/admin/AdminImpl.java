package com.shop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.Bean.ProductBean;
import com.shop.jdbc.*;


public class AdminImpl implements Admin {

	public int addproducts(ProductBean pb)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("insert into products values(?,?,?,?,?,?)");
			ps.setInt(1,pb.getPid());
			ps.setString(2, pb.getPname());
			ps.setString(3, pb.getPbrand());
			ps.setString(4, pb.getPcategory());
			ps.setInt(5,pb.getPquantity());
			ps.setFloat(6, pb.getPrprice());
			count=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		try {
			Djdbc1.release(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return count;		
		
	}
	
	public List<ProductBean> viewall()
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ProductBean> list=new ArrayList<>();
		//int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select * from products");
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				ProductBean pb=new ProductBean();
				pb.setPid(rs.getInt(1));
				pb.setPname(rs.getString(2));
				pb.setPbrand(rs.getString(3));
				pb.setPcategory(rs.getString(4));
				pb.setPquantity(rs.getInt(5));
				pb.setPrprice(rs.getFloat(6));
				list.add(pb);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		try {
			Djdbc1.release(con, ps,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return list;		
		
	}
	
	
	public ProductBean viewbyid(int pid)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProductBean pb = new ProductBean();
		//int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select * from products where pid=?");
			ps.setInt(1, pid);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				pb.setPid(rs.getInt(1));
				pb.setPname(rs.getString(2));
				pb.setPbrand(rs.getString(3));
				pb.setPcategory(rs.getString(4));
				pb.setPquantity(rs.getInt(5));
				pb.setPrprice(rs.getFloat(6));
			}
	}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		try {
			Djdbc1.release(con, ps,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		}
		return pb;
	
	
	}
	
	
	public int updateproducts(ProductBean pb)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=Djdbc1.getConnection();
			
			ps=con.prepareStatement("update products set pname=?,pbrand=?,pcategory=?,pquantity=?,pprice=? where pid=?");
			ps.setString(1,pb.getPname());
			ps.setString(2,pb.getPbrand());
			ps.setString(3,pb.getPcategory());
			ps.setInt(4, pb.getPquantity());
			ps.setFloat(5, pb.getPrprice());
			ps.setInt(6, pb.getPid());
	       count= ps.executeUpdate();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		try {
			Djdbc1.release(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
		
		return count;		
	}
	
	public int removeproducts(int productid)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("delete from products where pid=?");
			ps.setInt(1,productid);
			count=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		try {
			Djdbc1.release(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return count;		
	}
	
	public void updateproductqty(int pid,int qty)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs=null;
		
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select pquantity from products where pid=?");
			ps.setInt(1,pid);
			rs=ps.executeQuery();
			rs.next();
			int qty1=rs.getInt(1);
			int updqty=qty1-qty;
			if(updqty > 0)
			{
				ps1=con.prepareStatement("update products set pquantity=? where pid=?");
				ps1.setInt(1,updqty);
				ps1.setInt(2,pid);
				ps1.executeUpdate();
				
			}
			else
			{
				ps1=con.prepareStatement("update products set pquantity=? where pid=?");
				ps1.setInt(1,0);
				ps1.setInt(2,pid);
				ps1.executeUpdate();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		try {
			Djdbc1.release(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	
}

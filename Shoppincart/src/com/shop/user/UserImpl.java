package com.shop.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shop.Bean.*;


import com.shop.jdbc.Djdbc1;

public class UserImpl {

	public int usereg(UserBean ub)
	
	{
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("insert into users values(?,?,?,?)");
			ps.setInt(1,ub.getUid() );
			ps.setString(2, ub.getUname());
			ps.setLong(3, ub.getMobileno());
			ps.setString(4, ub.getUaddr());
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
	
	public int login(String name,long mno)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count1=0;
		try {
			
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select mobileno,userid from users where uname=?");
			ps.setString(1,name);
			rs=ps.executeQuery();
			while(rs.next())
			{
				long tmno=rs.getLong(1);
				int uid=rs.getInt(2);
				if(mno==tmno)
					{
						count1=uid;
				
					}
				else
					{
						count1=0;
					}
		} }catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count1;		
	}
	
	public int usereg(int uid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Integer> lid= new ArrayList<Integer>();
		int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select userid from users");
			rs=ps.executeQuery();
			while(rs.next())
			{
				int uid1=rs.getInt(1);
				lid.add(uid1);
				
			}
			
			if(lid.contains(uid))
			{
				count=1;
			}
			else
			{
				count=0;
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
		
		return count;
	}

	public int usereg(String username) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<String> lname= new ArrayList<String>();
		int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select uname from users");
			rs=ps.executeQuery();
			while(rs.next())
			{
				String uname=rs.getString(1);
				lname.add(uname);
				
			}
			
			if(lname.contains(username))
			{
				count=1;
			}
			else
			{
				count=0;
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
		
		return count;
	}

	public List<ProductBean> selectcategory(String category) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//ResultSetMetaData md=null;
		ProductBean pb;
		List<ProductBean> lp= new ArrayList<ProductBean>();
		//int count=0;
			try {
				
				con=Djdbc1.getConnection();
				ps=con.prepareStatement("select pid,pname,pbrand,pquantity,pprice from products where pcategory=?");
				ps.setString(1, category);
				rs=ps.executeQuery();
				//System.out.println("ProductID"+"\t"+"ProductName"+"\t"+"ProductBrand"+"\t"+"Quantity"+"\t"+"Price");
				while(rs.next())
				{
					pb=new ProductBean();
					pb.setPid(rs.getInt(1));
					pb.setPname(rs.getString(2));
					pb.setPbrand(rs.getString(3));
					pb.setPquantity(rs.getInt(4));
					pb.setPrprice(rs.getFloat(5));
		            lp.add(pb);
					
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
		
		 
		return lp;
	}

	public int quantityvalidate(int ch1,int pid) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int allow=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select pquantity from products where pid=?");
			ps.setInt(1,pid);
			rs=ps.executeQuery();
			rs.next();
			int prqty=rs.getInt(1);
			if(ch1<=prqty)
			{
				allow=1;
			}
			else
				allow=0;
			
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
		
		return allow;		
	
		
	}

	public Float calculateprice(int pid, int pqty) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Float price = null;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select pprice from products where pid=?");
			ps.setInt(1,pid);
			rs=ps.executeQuery();
			rs.next();
			float prid=rs.getFloat(1);
			 price=pqty*prid;
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
		
		
		return price;	
	}

	public void userprod(Float price,int qty, int uid, int pid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("insert into userproducts values(?,?,?,?)");
			ps.setFloat(1,price );
			ps.setInt(2, qty);
			ps.setInt(3, uid);
			ps.setInt(4, pid);
			ps.executeUpdate();
			
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

	public List<UserProd> purchase(int uid) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<UserProd> lp1= new ArrayList<UserProd>();
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select userproducts.pid,products.pname,products.pbrand,userproducts.price,userproducts.quantity from products,userproducts where products.pid=userproducts.pid and userid=?");
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			//System.out.println("ProductID"+"\t"+"ProductName"+"\t"+"ProductBrand"+"\t"+"Price"+"\t"+"Quantity");
			UserProd pb;
			
			while(rs.next())
			{
				pb=new UserProd();
				pb.setPid(rs.getInt(1));
				pb.setPname(rs.getString(2));
				pb.setPbrand(rs.getString(3));
				pb.setPrice(rs.getFloat(4));
				pb.setQuantity(rs.getInt(5));
	            lp1.add(pb);
				
			
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
		
		return lp1;
		
	}
	
	
	public float totalprice(int uid)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		float price = 0;
		
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("select sum(price) from userproducts where userid=?");
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			System.out.println("TotalPrice:"+"\t");
			while(rs.next())
			{				
				price=rs.getFloat(1);
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
		
		
		return price;
		
	}
	
	
	public void deleteuserprod(int uid) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs=null;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("insert into purchase (userno, productid) select userid,pid from userproducts where userid=?");
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			ps1=con.prepareStatement("delete from userproducts where userid=?");
			ps1.setInt(1, uid);
			ps1.executeUpdate();
			
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
		
		
		
	}
	
	
	
	public int delcartprod(int pid , int uid)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=Djdbc1.getConnection();
			ps=con.prepareStatement("delete from userproducts where pid=? and userid=?");
			ps.setInt(1, pid);
			ps.setInt(2, uid);
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
	
	
	
}
	

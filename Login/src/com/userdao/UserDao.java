package com.userdao;

import com.user.bean.UserBean;

public interface UserDao {
	
	int login(String uname,String pwd);
	
	int register(UserBean ub);
	
	String forgot(String uname);

}

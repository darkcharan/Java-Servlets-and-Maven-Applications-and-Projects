package com.login.dao;

import com.login.bean.Login;

public interface LoginDao {
	int insert(Login log);
	int retrive(Login log);

}

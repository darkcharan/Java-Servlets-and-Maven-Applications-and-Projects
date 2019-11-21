package com.student.dao;

import com.student.bean.StudentBean;

public interface StudentDao {
	
	int insert(StudentBean st);
	
	StudentBean retrive(int sno);
	

}

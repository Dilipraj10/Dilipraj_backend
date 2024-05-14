package com.spring.hibernatespring.dao;

import com.spring.hibernatespring.Student;

public interface StudentDao {
	
	int saveStudent(Student Student);
	Student getStudent(int id);
	void updateStudent(Student student);
	void delete(int id);

}

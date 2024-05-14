package com.spring.springjdbc;

import java.util.List;

public interface EmployeeDao {
	
	int insertEmployee(Employee emp);
	int updateEmployee(Employee emp);
	boolean deleteEmployee(Employee emp);
	List<Employee> selectAllEmployee();

}

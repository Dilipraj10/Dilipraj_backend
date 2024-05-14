package com.spring.springjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("employeeDao")
public class EmployeeDaoImp implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertEmployee(Employee emp) {
		String query = "insert into employee(id,name,place) values(?,?,?)";
		return jdbcTemplate.update(query,emp.getId(),emp.getName(),emp.getPlace());
	}
	
	@Override
	public int updateEmployee(Employee emp) {
		String query = "update employee set name = ?,place = ? where id = ?";
		return jdbcTemplate.update(query, emp.getName(),emp.getPlace(),emp.getId());
		
	}
	
	@Override
	public boolean deleteEmployee(Employee emp) {
		String query = "delete from employee where id = ?";
		return jdbcTemplate.update(query, emp.getId()) > 0;
	}
	
	@Override
	public List<Employee> selectAllEmployee() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, new EmployeeMapper() );

	}



}

package com.excel.demo.service;

import java.util.List;

import com.excel.demo.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto addEmployee(EmployeeDto dto);
    public boolean deleteEmployee(int id);
    public List<EmployeeDto> getAllEmployee();
	public EmployeeDto getEmployeeById(int id);
	public EmployeeDto updateEmployee(EmployeeDto dto);
    
}



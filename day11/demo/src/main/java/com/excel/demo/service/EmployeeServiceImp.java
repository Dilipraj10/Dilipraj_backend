package com.excel.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
			
	@Override
	public EmployeeDto addEmployee(EmployeeDto dto)
	{
		Employee employee = Employee.builder().fisrtName(dto.getFisrtName()).lastName(dto.getLastName()).mobileNO(dto.getMobileNo()).aadharNo(dto.getAadharNo()).employeeNo(dto.getEmployeeNo()).panNo(dto.getPanNo()).build();
		Employee save = employeeRepository.save(employee);
		return EmployeeDto.builder().id(save.getId()).aadharNo(save.getAadharNo()).panNo(save.getPanNo()).employeeNo(save.getEmployeeNo()).fisrtName(save.getFisrtName()).lastName(save.getLastName()).mobileNo(save.getMobileNO()).build();
	}
	
	@Override
	public boolean deleteEmployee(int id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
	}
	
	
	@Override
	public List<EmployeeDto> getAllEmployee()
	{
		return employeeRepository.findAll().stream().map(e -> EmployeeDto.builder().id(e.getId()).fisrtName(e.getFisrtName()).lastName(e.getLastName()).aadharNo(e.getAadharNo()).employeeNo(e.getEmployeeNo()).mobileNo(e.getMobileNO()).panNo(e.getPanNo()).build()).toList();
	
	}
	

}

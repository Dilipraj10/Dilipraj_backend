package com.excel.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excel.demo.constant.EmployeeConstant;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.exception.EmployeeNotFoundException;
import com.excel.demo.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		Employee employee = Employee.builder().fisrtName(dto.getFisrtName()).lastName(dto.getLastName())
				.mobileNo(dto.getMobileNo()).aadharNo(dto.getAadharNo()).employeeNo(dto.getEmployeeNo())
				.panNo(dto.getPanNo()).build();
		Employee save = employeeRepository.save(employee);
		return EmployeeDto.builder().id(save.getId()).aadharNo(save.getAadharNo()).panNo(save.getPanNo())
				.employeeNo(save.getEmployeeNo()).fisrtName(save.getFisrtName()).lastName(save.getLastName())
				.mobileNo(save.getMobileNo()).build();
	}

	@Override
	public boolean deleteEmployee(int id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		return employeeRepository.findAll().stream()
				.map(e -> EmployeeDto.builder().id(e.getId()).fisrtName(e.getFisrtName()).lastName(e.getLastName())
						.aadharNo(e.getAadharNo()).employeeNo(e.getEmployeeNo()).mobileNo(e.getMobileNo())
						.panNo(e.getPanNo()).build())
				.toList();

	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			Employee dto = optional.get();
			return EmployeeDto.builder().id(dto.getId()).fisrtName(dto.getFisrtName()).lastName(dto.getLastName())
					.mobileNo(dto.getMobileNo()).aadharNo(dto.getAadharNo()).employeeNo(dto.getEmployeeNo())
					.panNo(dto.getPanNo()).build();
		}
		throw new EmployeeNotFoundException(EmployeeConstant.EMPLOYEE_ID_NOT_FOUND);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {
		Optional<Employee> emp = employeeRepository.findById(dto.getId());
		if (emp.isPresent()) {
			Employee newEmp = emp.get();
			newEmp.setFisrtName(dto.getFisrtName());
			newEmp.setLastName(dto.getLastName());
			newEmp.setMobileNo(dto.getMobileNo());
		}

		throw new EmployeeNotFoundException(EmployeeConstant.EMPLOYEE_ID_NOT_FOUND);
	}

}

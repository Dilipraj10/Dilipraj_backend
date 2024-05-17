package com.excel.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.utils.Utils;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository EmployeeRepository;

	
	@Override
	public String savePrimaryInfo(EmployeePrimaryInfoDto dto) {
		if(!EmployeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo employee1 = Utils.dtoToEntity(dto);
			EmployeePrimaryInfo employee = EmployeeRepository.save(employee1);
			return employee.getEmployeeId();
		}
		
		return null;
	}
	
}

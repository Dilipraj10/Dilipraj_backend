package com.excel.lms.utils;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;

public class Utils {

	public static EmployeePrimaryInfo dtoToEntity(EmployeePrimaryInfoDto dto)
	{
		EmployeePrimaryInfo employee =  EmployeePrimaryInfo.builder().employeeId(dto.getEmployeeId()).employeeName(dto.getEmployeeName()).
			dateOfJoining(dto.getDateOfJoining()).dateOfBirth(dto.getDateOfBirth()).email(dto.getEmail())
			.bloodGroup(dto.getBloodGroup()).designation(dto.getDesignation()).gender(dto.getGender())
			.nationality(dto.getNationality()).employeeStatus(dto.getEmployeeStatus()).build();
		
		return employee;
		
	}
	
}

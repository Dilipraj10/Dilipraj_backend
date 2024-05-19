package com.excel.lms.utils;

import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.EmployeeAddressDetails;
import com.excel.lms.entity.EmployeeBankDetails;
import com.excel.lms.entity.EmployeeContact;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;

import lombok.Builder;


public class Utils {

	public static EmployeePrimaryInfo dtoToEntity(EmployeePrimaryInfoDto dto)
	{
		EmployeePrimaryInfo employee =  EmployeePrimaryInfo.builder().employeeId(dto.getEmployeeId()).employeeName(dto.getEmployeeName()).
			dateOfJoining(dto.getDateOfJoining()).dateOfBirth(dto.getDateOfBirth()).email(dto.getEmail())
			.bloodGroup(dto.getBloodGroup()).designation(dto.getDesignation()).gender(dto.getGender())
			.nationality(dto.getNationality()).employeeStatus(dto.getEmployeeStatus()).build();
		
		return employee;
		
	}
	
	public static EmployeeSecondaryInfo dtoToEntity(EmployeeSecondaryInfoDto dto)
	{
		EmployeeSecondaryInfo employee = EmployeeSecondaryInfo.builder().PanNo(dto.getPanNo()).aadharNo(dto.getAadharNo()).
				fatherName(dto.getFatherName()).motherName(dto.getFatherName()).spouse(dto.getSpouse())
				.passportNo(dto.getPossportNo()).maritalStatus(dto.getMaritalStatus()).build();
		return employee;
	}
	
	
	public static EmployeeBankDetails dtoToEntity(EmployeeBankDetailsDto dto)
	{
		EmployeeBankDetails employee = EmployeeBankDetails.builder().accountNo(dto.getAccountNo()).bankName(dto.getBankName()).ifsCode(dto.getIfsCode())
				.branch(dto.getBranch()).state(dto.getState()).build();
		return employee;
	}
	
	
	public static EmployeeAddressDetails dtoToEntity(EmployeeAddressDetails dto)
	{
		EmployeeAddressDetails employee = EmployeeAddressDetails.builder().addressType(dto.getAddressType()).doorNo(dto.getDoorNo()).
				street(dto.getStreet()).locality(dto.getLocality()).city(dto.getcity()).state(dto.getState()).pinCode(dto.getPincode()).
				landmark(dto.getLandMark()).build();
		return employee;
	}
	
	
	public static EmployeeContact dtoToEntity(EmployeeContact dto)
	{
		EmployeeContact employee = EmployeeContact.builder().contactType(dto.getContactType()).contactNo(dto.getContactNo()).build();
		return employee;
	}
	
	
	
	
	
}

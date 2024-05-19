package com.excel.lms.service;

import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeeContactDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.EmployeeContact;

public interface EmployeeService {

	public String savePrimaryInfo(EmployeePrimaryInfoDto dto);

	public String saveSecondaryEmpInfo(EmployeeSecondaryInfoDto dto);

	public String addBankDetails(EmployeeBankDetailsDto dto);
	
	public String addContactDetails(EmployeeContactDto dto);

}

package com.excel.lms.service;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExperienceListDto;
import com.excel.lms.dto.TechnicalSkillListDto;

public interface EmployeeService {
	
	public String savePrimaryInfo(EmployeePrimaryInfoDto dto);
	
	public String saveSecondaryInfo(EmployeeSecondaryInfoDto dto);
	
	public String saveBankInfo(EmployeeBankDetailsDto dto);

	public String saveEducation(EducationListDto dto);

	public String saveAddress(AddressListDto dto);

	public String saveContact(ContactListDto dto);

	public String saveExperience(ExperienceListDto dto);

	public String saveSkills(TechnicalSkillListDto dto);

}

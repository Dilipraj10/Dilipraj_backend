package com.excel.lms.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.excel.lms.dto.ContactDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeAddressDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeeEducationInfoDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExperienceDto;
import com.excel.lms.dto.TechnicalSkillDto;
import com.excel.lms.entity.EmployeeAddressDetails;
import com.excel.lms.entity.EmployeeBankDetails;
import com.excel.lms.entity.EmployeeContact;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExperience;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.EmployeeTechnicalSkill;

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
		EmployeeSecondaryInfo employee = EmployeeSecondaryInfo.builder().panNo(dto.getPanNo()).aadharNo(dto.getAadharNo()).
	fatherName(dto.getFatherName()).motherName(dto.getFatherName()).spouseName(dto.getSpouseName())
	.passportNo(dto.getPassportNo()).maritalStatus(dto.getMaritalStatus()).build();
	
	return employee;
		
	}

	public static EmployeeBankDetails bankDtoToEntity(EmployeeBankDetailsDto dto) {
		
		EmployeeBankDetails bankDetails =  EmployeeBankDetails.builder().bankId(dto.getBankId()).accountNo(dto.getAccountNo()).bankName(dto.getBankName())
		.accountType(dto.getAccountType()).ifscCode(dto.getIfscCode()).branch(dto.getBranch()).state(dto.getState()).build();
		return bankDetails;
	}
	
	public static List<EmployeeEducationDetails> educationDtoToEntity(List<EmployeeEducationInfoDto> dto){
		return dto.stream().map(edu -> EmployeeEducationDetails.builder()
				.educationType(edu.getEducationType()).educationDetailsId(edu.getEducationDetailsId())
				.yearOfPassing(edu.getYearOfPassing()).percentage(edu.getPercentage())
				.universityName(edu.getUniversityName()).instituteName(edu.getInstituteName())
				.specialization(edu.getSpecialization()).state(edu.getState())
				.build()).collect(Collectors.toList());
				
	}

	public static List<EmployeeAddressDetails> addressDtoToEntity(List<EmployeeAddressDto> dto) {
		return dto.stream().map(add -> EmployeeAddressDetails.builder()
				.addressType(add.getAddressType()).doorNo(add.getDoorNo()).street(add.getStreet())
				.locality(add.getLocality()).city(add.getCity()).state(add.getState())
				.pinCode(add.getPinCode()).landMark(add.getLandMark())
				.build()).collect(Collectors.toList());
	}

	public static List<EmployeeContact> contactDtoToEntity(List<ContactDto> contacts) {
		return contacts.stream().map(con -> EmployeeContact.builder()
				.contactType(con.getContactType()).contactNo(con.getContactNo())
				.build()).collect(Collectors.toList());
	}

	public static List<EmployeeExperience> experiencrDtoToEntity(List<ExperienceDto> experiences) {
		return experiences.stream().map(exp -> EmployeeExperience.builder()
				.companyName(exp.getCompanyName()).yearOfExperience(exp.getYearOfExperience())
				.dateOfJoining(exp.getDateOfJoining()).dateOfRelieving(exp.getDateOfRelieving())
				.designation(exp.getDesignation()).location(exp.getLocation())
				.build()).collect(Collectors.toList());
	}

	public static EmployeeTechnicalSkill dtoToTechnicalEntity(TechnicalSkillDto skill) {
		
		
		return EmployeeTechnicalSkill.builder().skillType(skill.getSkillType())
				.skillRating(skill.getSkillRating())
				.yearOfExperience(skill.getYearOfExperience())
				.employees(new ArrayList<>())
				.build();
	}

}

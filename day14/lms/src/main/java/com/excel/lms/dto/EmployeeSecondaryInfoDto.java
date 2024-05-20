package com.excel.lms.dto;

import com.excel.lms.entity.EmployeePrimaryInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSecondaryInfoDto {

	private int secondaryInfoId;
	
	private String employeeId;

	private String panNo;

	private Integer aadharNo;

	private String fatherName;

	private String motherName;

	private String spouseName;

	private String passportNo;

	private String maritalStatus;

	
}

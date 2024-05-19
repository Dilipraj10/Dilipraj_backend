package com.excel.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class EmployeeSecondaryInfoDto {


	private int secondaryInfoId;
	
	private String panNo;
	
	private Integer aadharNo;
	
	private String fatherName;
	
	private String motherName;
	
	private String spouseName;
	
	private String passportNo;
	
	private String maritalStatus;
}

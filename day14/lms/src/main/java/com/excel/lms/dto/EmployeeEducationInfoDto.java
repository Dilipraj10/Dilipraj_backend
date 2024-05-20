package com.excel.lms.dto;

import java.time.LocalDate;

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
public class EmployeeEducationInfoDto {

	private String employeeId;

	private int educationDetailsId;

	private String educationType;

	private LocalDate yearOfPassing;

	private double percentage;

	private String universityName;

	private String instituteName;

	private String specialization;

	private String state;

}

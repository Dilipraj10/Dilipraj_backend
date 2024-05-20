package com.excel.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.excel.lms.entity.EmployeeExperience;
import com.excel.lms.entity.EmployeePrimaryInfo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class ExperienceListDto {

	private String employeeId;
	private List<ExperienceDto> experiences;
}

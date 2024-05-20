package com.excel.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class EmployeeExperience {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceId;
	
	private String companyName;
	private int yearOfExperience;
	private LocalDate dateOfJoining;
	private LocalDate dateOfRelieving;
	private String designation;
	private String location;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private EmployeePrimaryInfo employee;

}

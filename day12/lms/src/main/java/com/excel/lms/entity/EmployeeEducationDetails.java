package com.excel.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class EmployeeEducationDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationDetailsId;
	
	@Column(name = "education_type")
	private String educationType;
	
	@Column(name = "year_of_passing")
	private LocalDate yearOfPassing;
	
	@Column(name = "percentage")
	private double percentage;
	
	@Column(name = "university_name")
	private String universityName;
	
	@Column(name = "institute_name")
	private String instituteName;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "state")
	private String state;
	
	
	@Override
	public String toString() {
		return "EmployeeEducationDetails [educationType=" + educationType + ", yearOfPassing=" + yearOfPassing
				+ ", percentage=" + percentage + ", universityName=" + universityName + ", instituteName="
				+ instituteName + ", specialization=" + specialization + ", state=" + state + "]";
	}
	 
	
	

}

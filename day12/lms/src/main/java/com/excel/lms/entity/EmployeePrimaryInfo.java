package com.excel.lms.entity;

import java.time.LocalDate;

import com.excel.lms.enums.Designation;
import com.excel.lms.enums.EmployeeStatus;
import com.excel.lms.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer primaryInfoId;
	
	@Column(name = "employe_id", nullable = true, unique = true, updatable = false )
	private String employeeid;
	
	@Column(name = "employee_name", nullable = true)
	private String employeeName;
	
	@Column(name = "date_of_joining" , nullable = true)
	private LocalDate dateOfJoining;
	
	@Column(name = "date_of_birth" , nullable = true)
	private LocalDate dateOfBirth;
	
	@Column(name = "email" , nullable = true)
	private String email;
	
	@Column(name = "blood_group" , nullable = true)
	private String bloodGroup;
	
//	@Column(name = "designation" , nullable = true)
	@Enumerated(EnumType.STRING)
	private Designation designation;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "nationality" , nullable = true)
	private String nationality;
	
//	@Column(name = "employee_status" , nullable = true)
	@Enumerated(EnumType.STRING)
	private EmployeeStatus employeeStatus;
	
	

	@Override
	public String toString() {
		return "EmployeePrimaryInfo [id=" + id + ", employeeid=" + employeeid + ", employeeName=" + employeeName
				+ ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", bloodGroup=" + bloodGroup + ", designation=" + designation + ", gender=" + gender
				+ ", nationality=" + nationality + ", employeeStatus=" + employeeStatus + "]";
	}
	
	
}

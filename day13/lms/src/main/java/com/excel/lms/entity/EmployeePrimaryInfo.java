package com.excel.lms.entity;

import java.time.LocalDate;
import java.util.List;

import com.excel.lms.enums.Designation;
import com.excel.lms.enums.EmployeeStatus;
import com.excel.lms.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "employee_primary_info")
@Builder
public class EmployeePrimaryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer primaryInfoId;
	
	@Column(name = "employe_id", nullable = true, unique = true, updatable = false )
	private String employeeId;
	
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
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "employeePrimaryInfo")
	private List<EmployeeAddressDetails> employeeaddressdetails;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee" )
	private EmployeeBankDetails bankDetails;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
	private List<EmployeeContact> contact;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
	private List<EmployeeEducationDetails> education;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
	private List<EmployeeExperience> experience;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
	private EmployeeSecondaryInfo secondaryInfo;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employees")
	private List<EmployeeTechnicalSkill> skill;
	
	
	
	
	

	
	
	
}

package com.excel.lms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "employee_seondary_info")
public class EmployeeSecondaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int secondaryInfoId;
	
	@Column(name = "pan_no" ,nullable = true, unique = true)
	private String panNo;
	
	@Column(name = "aadhar_no" ,nullable = true, unique = true)
	private Integer aadharNo;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "spouse_name")
	private String spouseName;
	
	@Column(name = "passport_no")
	private String passportNo;
	
	@Column(name = "matiral_status")
	private String maritalStatus;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private EmployeePrimaryInfo employee;

	
	
}

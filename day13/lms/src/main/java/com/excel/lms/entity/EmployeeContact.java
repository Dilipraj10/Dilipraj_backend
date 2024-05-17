package com.excel.lms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeContact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int conactId;
	private String contactType;
	private long contactNo;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private EmployeePrimaryInfo employee;

}

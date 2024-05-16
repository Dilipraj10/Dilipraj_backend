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

public class EmployeeBankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	
	@Column(name = "account_no" ,nullable = true)
	private long accountNo;
	@Column(name = "bank_name")
	private String bankName;
	
	private String accountType;
	private String ifscCode;
	private String branch;
	private String state;
	
	@Override
	public String toString() {
		return "EmployeeBankDetails [accountNo=" + accountNo + ", bankName=" + bankName + ", accountType=" + accountType
				+ ", ifscCode=" + ifscCode + ", branch=" + branch + ", state=" + state + "]";
	}
	
	
	
	

}

package com.excel.lms.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor@Builder
public class EmployeeBankDetailsDto {

private int bankId;
	
	private long accountNo;
	private String bankName;
	private String accountType;
	private String ifscCode;
	private String branch;
	private String state;
}

package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmployeeStatus {

	ACTIVE("ACTIVE"),TERMINATE("TERMINATE"),ABSCONNED("ABSCONNED");
	
	private final String employeeStatus;
}

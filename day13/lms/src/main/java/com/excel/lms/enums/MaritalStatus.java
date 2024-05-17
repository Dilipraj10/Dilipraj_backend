package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaritalStatus {
	
	MARRIED("MARRIED"),UNMARRIED("UNMARRIED"),DIVORCED("DIVORCED");
	
	private final String maritalStatus;

}

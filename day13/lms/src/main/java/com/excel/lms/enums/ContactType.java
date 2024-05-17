package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContactType {
	
	PERSONAL("PERSONAL"),OFFICIAL("OFFICIAL");
	
	private final String contactType; 

}

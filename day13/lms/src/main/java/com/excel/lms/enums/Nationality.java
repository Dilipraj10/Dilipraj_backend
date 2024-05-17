package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Nationality {

	INDIAN("INDIAN"),OTHERS("OTHERS");
	
	private final String nationality;
}

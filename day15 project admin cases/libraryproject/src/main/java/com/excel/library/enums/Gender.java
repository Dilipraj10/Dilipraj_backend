package com.excel.library.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
	
	MALE("MALE"), FEMALE("FEMALE"), OTHERS("OTHERS");
	
	private final String gender;
	

}

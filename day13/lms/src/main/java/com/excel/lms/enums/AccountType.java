package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountType {

	SAVINGS("SAVINGS"),CURRENT("CURRENT");
	
	private final String accountType;
}

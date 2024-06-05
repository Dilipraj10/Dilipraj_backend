package com.excel.library.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
	
	ADMIN("ADMIN"), USER("USER");
	
	private final String type;
	

}

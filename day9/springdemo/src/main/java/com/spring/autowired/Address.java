package com.spring.autowired;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
	
	private String place;

	@Override
	public String toString() {
		return "Address [place=" + place + "]";
	}

	
	
}

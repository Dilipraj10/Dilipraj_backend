package com.spring.autowired.annotation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

	private String place;

	@Override
	public String toString() {
		return "Address [place=" + place + "]";
	}
	
}

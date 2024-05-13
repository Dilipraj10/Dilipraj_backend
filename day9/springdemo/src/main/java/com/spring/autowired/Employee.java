package com.spring.autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	
	private Address address;

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	
}

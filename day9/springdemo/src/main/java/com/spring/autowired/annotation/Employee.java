package com.spring.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //@autowired giving annotation to setter
public class Employee {
	
	@Autowired
	@Qualifier("address2")  //to achieve this we need have zero parameter constructor
	private Address address;
	/*
	 2 with autowired in constructor
	 3 with autowired in setter method
	 */
	//@Autowired //to constructor is required to give @autowired annotation or we can give to setter
//	public Employee(Address address) {
//		this.address=address;
//	}
	
	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	
}

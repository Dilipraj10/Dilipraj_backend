package com.spring.constructor;

public class Address {
	
	private int id;
	private String place;
	
	public Address(int id, String place) {
		super();
		this.id = id;
		this.place = place;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", place=" + place + "]";
	}
	
}

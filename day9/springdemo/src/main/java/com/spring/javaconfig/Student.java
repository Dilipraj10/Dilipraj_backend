package com.spring.javaconfig;

public class Student {

	private Somosa somosa;

	public Somosa getSomosa() {
		return somosa;
	}

	public void setSomosa(Somosa somosa) {
		this.somosa = somosa;
	}
	
	public void study() {
		this.somosa.displayPrice();
		System.err.println("Student is studying!!!");
	}
	
}

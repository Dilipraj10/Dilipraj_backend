package com.spring.hibernatespring;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Student {
	@Id
	private int id;
	private String name;
	private String City;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		City = city;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", City=" + City + "]";
	}
	

}

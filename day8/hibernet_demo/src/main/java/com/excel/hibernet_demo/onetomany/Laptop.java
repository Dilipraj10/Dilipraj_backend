//package com.excel.hibernet_demo.onetomany;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "laptop")
//public class Laptop {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "laptop")
//	private int id; 
//	
//	@Column(name = "brand")
//	private String brand;
//	
//	@Column(name = "serianl_no")
//	private String serialNo;
//	
//	
//	
//	public int getId() {
//		return id;
//	}
//
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//
//	public String getBrand() {
//		return brand;
//	}
//
//
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//
//
//	public String getSerialNo() {
//		return serialNo;
//	}
//
//
//
//	public void setSerialNo(String serialNo) {
//		this.serialNo = serialNo;
//	}
//
//
//
//	public Student getStudent() {
//		return student;
//	}
//
//
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Student student;
//
//}

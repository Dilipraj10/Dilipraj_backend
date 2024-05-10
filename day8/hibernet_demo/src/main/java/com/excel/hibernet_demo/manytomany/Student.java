//package com.excel.hibernet_demo.manytomany;
//
//import java.util.List;
//
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "student")
//
//public class Student {
//	
//	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public List<Book> getBooks() {
//		return books;
//	}
//
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "student_id")
//	private int id;
//	
//	@Column(name = "student_name")
//	private String name;
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<Book> books;
//}

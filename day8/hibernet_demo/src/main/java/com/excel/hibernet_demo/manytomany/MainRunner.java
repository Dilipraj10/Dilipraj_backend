//package com.excel.hibernet_demo.manytomany;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class MainRunner {
//
//	public static void main(String[] args) {
//		
//		
//		EntityManagerFactory fac = Persistence.createEntityManagerFactory("student");
//		EntityManager manager = fac.createEntityManager();
//		EntityTransaction tran = manager.getTransaction();
//		
//		List<Student> student = new ArrayList<Student>();
//		List<Book> books = new ArrayList<Book>();
//
//		Student s1 = new Student();
//		Student s2 = new Student();
//		Student s3 = new Student();
//		
//		Book b1 = new Book();
//		Book b2 = new Book();
//		Book b3 = new Book();
//	
//		s1.setName("john");
//		s1.setBooks(books); 
//		
//		s2.setName("dilip");
//		s2.setBooks(books);
//
//		s3.setName("raj");
//		s3.setBooks(books);
//
//		
//		b1.setTitle("super man");
//		b2.setTitle("hanuman");
//		b3.setTitle("beem");
//		
//		books.add(b1);
//		books.add(b2);
//		books.add(b3);
//		
//		student.add(s1);
//		student.add(s2);
//		student.add(s3);
//		
//		b1.setStudents(student);
//		b2.setStudents(student);
//		b3.setStudents(student);
//		
//		tran.begin();
//		manager.persist(s1);
//		tran.commit();
//		
//	}
//
//}

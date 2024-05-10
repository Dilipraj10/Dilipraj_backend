//package com.excel.hibernet_demo.onetomany;
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
//		EntityManagerFactory fac = Persistence.createEntityManagerFactory("student");
//		EntityManager manager = fac.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		List <Laptop> laptops =new ArrayList<>();
//		
//		Laptop laptop1 = new Laptop();
//		Laptop laptop2 = new Laptop();
//		Laptop laptop3 = new Laptop();
//		Student student = new Student();
//		
//		laptop1.setBrand("Del");
//		laptop1.setSerialNo("D1");
//		laptop1.setStudent(student);
//		 
//		laptop2.setBrand("Lenovo");
//		laptop2.setSerialNo("L1");
//		laptop2.setStudent(student); 
//		
//	
//		laptop3.setBrand("Mac");
//		laptop3.setSerialNo("M1");
//		laptop3.setStudent(student);
//		
//		laptops.add(laptop1);
//		laptops.add(laptop2);
//		laptops.add(laptop3);
//		
//		student.setName("John");
//		student.setAge(23);
//		student.setLaptops(laptops);
//		
//		transaction.begin();
//		manager.persist(student);
//		transaction.commit();
//		System.out.println(manager.find(Student.class, 1));
//		
//		
//	}
//
//}

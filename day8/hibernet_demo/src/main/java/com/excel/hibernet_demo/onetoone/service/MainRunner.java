//package com.excel.hibernet_demo.onetoone.service;
//
//import com.excel.hibernet_demo.onetoone.entity.Student;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class MainRunner {
//	
//	
//	public static void main(String[] args) {
//		
//		EntityManagerFactory fac = Persistence.createEntityManagerFactory("student");
//		EntityManager manager = fac.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		Student st = new Student();
//		st.setName("swamy");
//		st.setAge(22);
//		
//	
//		transaction.begin();
//		manager.persist(st);
//		transaction.commit();
//		manager.close();
//	}
//}

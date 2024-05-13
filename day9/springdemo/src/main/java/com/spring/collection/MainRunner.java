package com.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/collection/config.xml");
		Employee employee1 = (Employee)context.getBean("employee1");
		System.out.println("name: " + employee1.getName());
		System.out.println("Phones:" + employee1.getPhones());
		System.out.println("Skills: " + employee1.getSkills());
		System.out.println("Nominess" + employee1.getNominess());
	}

}

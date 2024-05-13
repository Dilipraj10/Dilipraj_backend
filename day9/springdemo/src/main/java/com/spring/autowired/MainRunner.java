package com.spring.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/autowired/config.xml");
		Employee emp = (Employee)con.getBean("employee1",Employee.class); //employee.class is becoz its by autowire
		System.out.println(emp);
	}

}

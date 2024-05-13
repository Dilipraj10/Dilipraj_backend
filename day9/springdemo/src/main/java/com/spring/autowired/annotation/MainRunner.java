package com.spring.autowired.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.autowired.annotation.Employee;

public class MainRunner {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/autowired/annotation/config.xml");
//		Employee emp = (Employee)con.getBean("employee1"); //employee object casting
		Employee emp = con.getBean("employee1",Employee.class);
		System.out.println(emp);
	}

}

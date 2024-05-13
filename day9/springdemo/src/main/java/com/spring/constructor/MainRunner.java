package com.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/constructor/congif.xml");
		
		Employee employee1 = (Employee)context.getBean("employee");
		System.out.println(employee1);
		
	}

}

package com.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {

	public static void main(String[] args) {

		ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfig.class);
	}

}

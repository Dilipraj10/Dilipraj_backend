package com.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.javaconfig")
public class JavaConfig {

	@Bean(name= {"student","std","studentdemo"})
	public Student getStudent() {
		return new Student();
	}
	
	@Bean
	public Somosa getSomosa() {
		return new Somosa();
		
	}
}

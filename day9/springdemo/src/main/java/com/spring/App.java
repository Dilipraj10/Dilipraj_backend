package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/config.xml");
    	
    	Student student1 = (Student)context.getBean("student1"); //student is present in config.xml in that id 
    	Student student2 = (Student)context.getBean("student2");
    	Student student3 = (Student)context.getBean("student3"); 

    	System.err.println(student1);
    	System.err.println(student2);
    	System.err.println(student3);
    	
    }
}

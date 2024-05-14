package com.spring.hibernatespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernatespring.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/hibernatespring/config.xml");
    	StudentDao dao = con.getBean("stDao",StudentDao.class);
    	
    	Student stu = new Student();
    	stu.setId(003);
    	stu.setName("raj");
    	stu.setCity("Banglore");
    	
//    	dao.saveStudent(stu);
    	Student i = dao.getStudent(2);
    	System.out.println(i);
    	
    	dao.updateStudent(stu);
    	
    	dao.delete(1);
    	
    }
}

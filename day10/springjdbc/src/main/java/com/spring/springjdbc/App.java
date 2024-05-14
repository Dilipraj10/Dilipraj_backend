package com.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfig.class);
    	EmployeeDao dao = con.getBean("employeeDao",EmployeeDao.class);
    	
    	Employee emp = new Employee();  
//    	emp.setId(001);
//    	emp.setName("Dilip"); 
//    	emp.setPlace("Banglore");
//    	int res1 = dao.insertEmployee(emp);
//    	System.out.println(res1);
    	
//    	int res2 = dao.updateEmployee(new Employee(1,"akshay","Manglore"));
//    	System.out.println(res2);
//    	
//    	boolean res3 = dao.deleteEmployee(new Employee(1,"Dilip","Banglore"));
//    	System.out.println(res3);
    	
		System.out.println("List of Employee is:");
		for (Employee e : dao.selectAllEmployee()) {
			System.out.println(e);
		}
    	
    	

     }
    	
}


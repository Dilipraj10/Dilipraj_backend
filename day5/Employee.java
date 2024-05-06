package day5;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Employee {
	
	private int empId;
	private String empName;
	private String empDept;
	private String empDesig;
	
	public Employee(int empId,String empName, String empDept,String empDesig)
	{
		this.empId=empId;
		this.empName=empName;
		this.empDept=empDept;
		this.empDesig=empDesig;
	}
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDept=" + empDept + ", empDesig=" + empDesig
				+ "]";
	}

	@Override
	public int hashCode() {
		return empId;

	}
	@Override
	public boolean equals(Object o) {
		Employee emp=(Employee) o;
		return this.hashCode()==emp.hashCode();
	}
	

	public static void main(String[] args) {
		HashMap<Integer,Employee> map= new HashMap<>();
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			int empId=sc.nextInt();
			System.out.println("Enter Employee Name:");
			String empName=sc.next();
			System.out.println("Enter Employee dept:");
			String empdept=sc.next();
			System.out.println("Enter Employee desig:");
			String empdesig=sc.next();
			map.put(empId,new Employee(empId, empName, empdept,empdesig));
			System.out.println("want to add more employees:");
			String value=sc.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
		
		Set<Entry<Integer, Employee>> entrySet=map.entrySet();
		
		for(Entry<Integer, Employee> entry : entrySet) {
			System.out.println(entry.getKey() + "===>" + entry.getValue());
		}
	
	}

}

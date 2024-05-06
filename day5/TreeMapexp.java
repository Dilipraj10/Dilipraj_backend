package day5;

//import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map.Entry;

public class TreeMapexp {  

	public static void main(String[] args) {
		
		Comparator<Integer> com = new Comparator<Integer>() {
		
			@Override
		public int compare(Integer o1, Integer o2) {
			return (o1).compareTo(o2);
		}
		};
		
		//we cannot sort by value in treeMap
		//we can sort by only key
		
//		TreeMap<Integer,Employee> map= new TreeMap<>((o1,o2) -> o1.compare(o2));  using lambda condition its used to give condition
//		TreeMap<Integer,Employee> map= new TreeMap<>(Comparable :: compareTo); another way to compare the values with each other
		
		TreeMap<Integer,Employee> map= new TreeMap<>();
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

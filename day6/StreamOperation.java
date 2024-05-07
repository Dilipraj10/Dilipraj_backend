package day6;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperation {

	public static void main(String[] args) {
		
		List<Integer> list= Arrays.asList(1,2,3,3,4,5,6,7,8,9,162);
//		List<Integer> collect =list.stream().filter(e -> e%2==0).collect(Collectors.toList());
//		System.out.println(collect);
//		forEach(System.out::Println); to print ele
		
		//print check 1st ele starts with one
		// map converts one stream to another here int to string
		
		list.stream().map(e -> e+"").filter(e -> e.startsWith("1")).forEach(System.out::println);;
		
		//find duplicate ele
		Set<Integer> set = new HashSet();
		list.stream().filter(e -> !set.add(e)).forEach(System.out::println);
		
		//first ele use findfirst()
//		
		Integer orElse=list.stream().findFirst().orElse(0);
		System.out.println(orElse);
		
		//count of ele
		System.out.println(list.stream().distinct().count());
		
		//maximum ele
		Integer integer=list.stream().max((o1,o2) -> o1.compareTo(o2)).get();
		System.out.println("max " +integer);
		
		//minimum ele
		Integer integer1=list.stream().min((o1,o2) -> o1.compareTo(o2)).get();
		System.out.println("min " + integer1);
		
		//first non repeated letter in string
		//maptoobj convert on variable to object
		String s="java articles are a";
		Character character=s.chars().mapToObj(c -> (char) c).filter(e -> s.indexOf(e)==s.lastIndexOf(e)).findFirst().get();
		System.out.println(character);
		
		//repeated character
		System.out.println("repeating character");
		String s2="java articles are a";
		s.chars().mapToObj(c -> (char) c).filter(e -> s.indexOf(e)!=s.lastIndexOf(e)).distinct().forEach(System.out::println);
		System.out.println("end of repeating character");

		//first repeated character
		String s1="java articles are a";
		Character character1=s.chars().mapToObj(c -> (char) c).filter(e -> s.indexOf(e)!=s.lastIndexOf(e)).findFirst().get();
		System.out.println("first repeated char " + character1);
		
		//sort the ele
		list.stream().sorted().forEach(System.out::println);
		
		//sort in reverse order
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);	
		
		//first repeating integer it should give true
//		int size=list.stream().distinct().collect(Collectors.toList()).size();
//		System.out.print(size);
		
		//ele cube is greater then 50
//		list.stream().map(e -> e*e*e).filter(e -> e > 50).forEach(System.out::println));
		
		//frequency of ele
		String s3="asdoshfpsjdj";
		Map<Character, Long> collect=s3.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
		
		//frequency of ele whose count is 2
		List<String> names=Arrays.asList("AA","BB","AA","EE");
		names.stream().filter(e -> Collections.frequency(names, e)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((str,count) -> System.out.println(str + "====>" + count));
	}

}

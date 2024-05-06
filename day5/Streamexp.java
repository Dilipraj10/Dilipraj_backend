package day5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streamexp {

	public static void main(String[] args) {
		
		List<Integer> l1= Arrays.asList(1,2);
		List<Integer> l2= Arrays.asList(2,3,4,5);
//		long count=l1.stream().count();
//		l1.stream().distinct().forEach(ele -> System.out.println(ele)); //1 2 3 4
//		l1.stream().forEach(ele -> System.out.println(ele)); // 1 2 3 3 3 4 4 4
		
		Optional<Integer> first =l1.stream().filter(ele -> ele%2==0).findFirst();
		System.out.println(first.get()); 
		
//		System.out.println(first.orElseGet()-);  

		
		
//		this foreach loop will print all the elements.
//		distict() method is used to print to different ele.

//		System.out.print(count);
		Stream<Integer> s1 = l1.stream();
		

		
	}

}

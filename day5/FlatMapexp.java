package day5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapexp {

	public static void main(String[] args) {
		
		List<Integer> l1= Arrays.asList(1,2);
		List<Integer> l2= Arrays.asList(1,2);
		List<Integer> l3= Arrays.asList(1,2);
		
		List<List<Integer>> list=Arrays.asList(l1,l2,l3);
		
		List<Integer> flatmap=list.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		List<Integer> flatmap1=list.stream().flatMap(x -> x.stream().map(n -> n+1)).collect(Collectors.toList());
		Optional<List<Integer>> flatmap2=list.stream().reduce((a,b) -> a+b);

				System.out.println(flatmap);
				System.out.print(flatmap1);
				

	}

}

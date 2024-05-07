package day6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streamtask {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 2,3,10);
		List<Integer> list2 = Arrays.asList(9,8,7,6,5,4,3,3,2,7,8);
		
		Set<Integer> set= new HashSet();

		// seperate even numbers
		Map<Boolean, List<Integer>> integer = list.stream().collect(Collectors.partitioningBy(i -> i % 2 != 0));
		System.out.println("seperate even and odd " + integer);

		// remove duplicate ele
		System.out.println("remove duplicate ele");
		list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

		// sort the ele in reverse order
		System.out.println("reverse order ele");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		
		// multiples of 5
		System.out.println("multiples of 5");
		list.stream().filter(e -> e % 5 == 0).forEach(System.out::println);
		
		//marge two unsorted array to sorted single array without duplicate
		System.out.println("marge two unsorted array to sorted single array without duplicate");
		int[] a1= {9,5,3,8,2};
		int[] b1= {6,4,7,1,3};
		IntStream.concat(Arrays.stream(a1), Arrays.stream(b1)).sorted().distinct().forEach(System.out::println);
		
		//three max and min ele
		//min
		System.out.println("min");
		list.stream().sorted().limit(3).forEach(System.out::println);
		System.out.println("max");
		list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		
		//sort the list string in increasing order based on their length
		System.out.println("sort the list string in increasing order based on their length");
		List<String> ls=Arrays.asList("dilipraj","raj","mango","5dilip");
		ls.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);	
		
		
		//sum of array ele
		System.out.println("sum of array ele");
		int sum = Arrays.stream(a1).sum();
		System.out.println(sum);
		
		//avg of array ele
		System.out.println("avg");
		double avg = Arrays.stream(a1).average().getAsDouble();
		System.out.println(avg);
		
		//reverse an integer array
		System.out.println("reverse an integer array");
		IntStream.range(0, a1.length).map(i -> a1[a1.length-i-1]).forEach(System.out::println);
		
		//palindrom
		System.out.println("palindrom");
		String str="wow";
		boolean palin=IntStream.range(0, str.length()/2).noneMatch(i -> str.charAt(i) != str.charAt(str.length()-i-1));
		System.out.println(palin);
		
		
		//last ele of an array
		System.out.println("last ele of an array");
		String lastele= ls.stream().skip(ls.size()-1).findFirst().get();
		System.out.println("last element is: " + lastele);
		
		//Age of person in year
		System.out.println("Age of person in year");
		LocalDate birthDay=LocalDate.of(2000, 01, 10);
		LocalDate toDay=LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthDay, toDay));
		
		//remove duplicate ele
		System.out.println("remove duplicate ele");
		list.stream().distinct().forEach(System.out::println);
		
		
		//freq of each ele in array
		System.out.println("freq of each ele");
		Map<Integer, Long> freq= list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(freq);
		
		//join list string with suffix, prefix and dlimiter
		System.out.println("join list string with suffix, prefix and dlimiter");
		String spd=ls.stream().collect(Collectors.joining("Delimiter","Suffix","Prefix"));
		System.out.println(spd);
		
		//maximum and minimum num of list
		System.out.println("maximum and minimum num of list");
		int min=list.stream().sorted().findFirst().get();
		System.out.println("min " + min);
		
		int max=list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println("max " +max);
		
		//Anagram
		System.out.println("Anagram program");
		String s1="car";
		String s2="rac";
		s1=Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		String s3 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		boolean anagram=Optional.ofNullable(s1).map(e -> e.equals(s3)).get();
		System.out.println(anagram);
		
		
		//sum of all digits of number
		System.out.println("sum of all digits of number");
		int num=9870986;
		Integer value = Stream.of(String.valueOf(num).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(value);
		
		//Second largest num in a integer array
		System.out.println("Second largest num in a integer array");
		int secondLargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondLargest);
		
		//common elements between 2 arrays
		System.out.println("common elements between 2 arrays");
		list.stream().filter(list2::contains).forEach(System.out::println);
		
		//sum of first 10 numbers
		System.out.println("sum of first 10 numbers");
		int sum2 =IntStream.range(1, 11).sum();
		System.out.println(sum);
		
		//reverse each word of a string
		System.out.println("reverse each word of a string");
		String line="danieldilip";
		String reverseWord = Arrays.stream(line.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining());
		System.out.println(reverseWord);	
		
		//find string start with number
		System.out.println("find string start with number");
		ls.stream().filter(e -> Character.isDigit(e.charAt(0))).forEach(System.out::println);
		
		//find duplicate elements in array
		System.out.println("find duplicate elements in array");
		Set<Integer> duplicateElement = list.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
		System.err.println(duplicateElement);
		
		//Fibonaci series
		System.out.println("Fibonaci series");
		Stream.iterate(new int[] {0,1} ,f -> new int[] {f[1],f[0]+f[1]}).limit(10).map(f -> f[0]).forEach(i -> System.out.print(i+ " "));
	}
}

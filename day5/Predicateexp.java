package day5;

import java.util.function.Predicate;

public class Predicateexp {

	public static void main(String[] args) {
		
		Predicate<Integer> pr=a -> (a>18); //condition to check a is greater or not
		System.out.println(pr.test(20)); // passing a value to it and compares the values
	}

}

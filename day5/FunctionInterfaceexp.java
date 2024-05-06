package day5;

import java.util.function.Function;

public class FunctionInterfaceexp {

	public static void main(String[] args) {
		
		Function<String, Integer> fLength= s -> s.length();
		Function<String, String> fCase= s -> s.toUpperCase();
		
		System.out.println(fLength.apply("dilip"));
		System.out.println(fCase.apply("diLip"));
		System.out.println(fCase.andThen(fLength).apply("dilip")); //fcase excutes first then flenth, fcase output is input for flength		
	}

}

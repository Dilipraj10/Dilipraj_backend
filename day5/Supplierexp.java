package day5;

import java.util.function.Supplier;

public class Supplierexp {

	public static void main(String[] args) {
		
		Supplier<Integer> otp = () -> {
			int s=0;
			for(int i=0; i<6; i++) {
				s=s+(int)(Math.random()*18);
			}
			return s;
		};
		System.out.println(otp.get());
	}

}
